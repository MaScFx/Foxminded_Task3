package com.example.task3.fragments;

import static com.example.task3.model.constants.FillingCollections.FillingListCompleted;
import static com.example.task3.model.constants.FillingCollections.FillingMapCompleted;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task3.model.constants.ListTest;
import com.example.task3.model.constants.MapTest;
import com.example.task3.model.constants.TypeList;
import com.example.task3.model.constants.TypeMap;
import com.example.task3.model.fillingCollections.FillingList;
import com.example.task3.model.fillingCollections.FillingMap;
import com.example.task3.model.tests.iTest;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeadlessTestsFragment extends Fragment implements IDataKeeper {
    private ExecutorService executor;
    public static ArrayList<Integer> arrayList;
    public static LinkedList<Integer> linkedList;
    public static CopyOnWriteArrayList<Integer> copyOnWrite;

    public static HashMap<String, Integer> hashMap = new HashMap<>();
    public static TreeMap<String, Integer> treeMap = new TreeMap<>();

    private Handler handler;
    private final HashMap<Integer, WeakReference<ICollectionObserver>> dataObservers = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initHandler();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void runTests(List<iTest> testsList) {
        for (iTest test : testsList) {
            test.setHandler(handler);
            executor.execute((Runnable) test);
        }
    }

    @SuppressLint("HandlerLeak")
    private void initHandler() {
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (FillingListCompleted.getValue() == msg.what) {
                    Map tempResultMap = (Map<TypeList, List<Integer>>) msg.obj;
                    arrayList = (ArrayList<Integer>) tempResultMap.get(TypeList.ArrayList);
                    linkedList = (LinkedList<Integer>) tempResultMap.get(TypeList.LinkedList);
                    copyOnWrite = (CopyOnWriteArrayList<Integer>) tempResultMap.get(TypeList.CopyOnWrite);
                    dataObservers.get(ListTest.AddingBeginningAL.getValue()).get().collectionIsCompleted();
                } else if (FillingMapCompleted.getValue() == msg.what) {
                    Map tempResultMap = (Map<TypeMap, Map<String, Integer>>) msg.obj;
                    hashMap = (HashMap<String, Integer>) tempResultMap.get(TypeMap.HashMap);
                    treeMap = (TreeMap<String, Integer>) tempResultMap.get(TypeMap.TreeMap);
                    dataObservers.get(MapTest.AddingNewTM.getValue()).get().collectionIsCompleted();
                } else {
                    setResultNewData(msg.what, String.valueOf(msg.arg1));
                }
            }
        };
    }

    private void setResultNewData(Integer test, String data) {
        dataObservers.get(test).get().dataSetChanged(test, data);
    }

    @Override
    public void fillingList(Integer size, ICollectionObserver observer) {
        for (ListTest test : ListTest.values()) {
            dataObservers.put(test.getValue(), new WeakReference<>(observer));
        }
        executor.execute(new FillingList(size, handler));
    }

    @Override
    public void fillingMap(Integer size, ICollectionObserver observer) {
        for (MapTest test : MapTest.values()) {
            dataObservers.put(test.getValue(), new WeakReference<>(observer));
        }
        executor.execute(new FillingMap(size, handler));
    }
}
