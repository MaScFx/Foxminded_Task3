package com.example.task3.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task3.model.operations.IOperation;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    private final HashMap<Integer, WeakReference<IResultObserver>> dataObservers = new HashMap<>();
    private final HashMap<Integer, String> results = new HashMap<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initHandler();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void runOperation(List<IOperation> testsList, IResultObserver observer) {
        for (IOperation test : testsList) {
            dataObservers.put(test.getIDOperation(), new WeakReference<>(observer));
            test.setHandler(handler);
            executor.execute(test);
        }
    }

    @SuppressLint("HandlerLeak")
    private void initHandler() {
        handler = new Handler() {
            public void handleMessage(Message msg) {
                Integer idOperation = msg.what;
                String result = String.valueOf(msg.arg1);
                results.put(idOperation, result);
                dataObservers.get(idOperation).get().dataSetChanged(idOperation, result);
            }
        };
    }

    @Override
    public HashMap<Integer, String> getResults() {
        return results;
    }
}
