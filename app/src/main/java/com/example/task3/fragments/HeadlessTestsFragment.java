package com.example.task3.fragments;

import static com.example.task3.model.constants.FillingCollections.FillingListCompleted;
import static com.example.task3.model.constants.FillingCollections.FillingMapCompleted;
import static com.example.task3.model.constants.ListTests.*;
import static com.example.task3.model.constants.MapTests.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task3.model.constants.ListTests;
import com.example.task3.model.constants.MapTests;
import com.example.task3.model.constants.TypeList;
import com.example.task3.model.testsCollection.*;
import com.example.task3.model.constants.TypeMap;
import com.example.task3.model.fillingCollections.FillingList;
import com.example.task3.model.fillingCollections.FillingMap;
import com.example.task3.model.testsMap.AddingNewMap;
import com.example.task3.model.testsMap.RemovingMap;
import com.example.task3.model.testsMap.SearchByKeyMap;

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

public class HeadlessTestsFragment extends Fragment {
    private ExecutorService executor;
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private CopyOnWriteArrayList<Integer> copyOnWrite;

    private HashMap<String, Integer> hashMap = new HashMap<>();
    private TreeMap<String, Integer> treeMap = new TreeMap<>();

    private Handler handler;
    private WeakReference<NotifyDataSetChanged> listDataObserver;
    private WeakReference<NotifyDataSetChanged> mapDataObserver;

    private final HashMap<ListTests, String> listResults = new HashMap<>();
    private final HashMap<MapTests, String> mapResults = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initHandler();
        executor = Executors.newSingleThreadExecutor();
    }

    public void fillingListEnd(Map<TypeList, List<Integer>> result) {
        arrayList = (ArrayList<Integer>) result.get(TypeList.ArrayList);
        linkedList = (LinkedList<Integer>) result.get(TypeList.LinkedList);
        copyOnWrite = (CopyOnWriteArrayList<Integer>) result.get(TypeList.CopyOnWrite);
        executor.execute(() -> {
            executor.execute(new AddingBeginningList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new AddingBeginningList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new AddingBeginningList(copyOnWrite, TypeList.CopyOnWrite, handler));

            executor.execute(new AddingMiddleList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new AddingMiddleList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new AddingMiddleList(copyOnWrite, TypeList.CopyOnWrite, handler));

            executor.execute(new AddingEndList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new AddingEndList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new AddingEndList(copyOnWrite, TypeList.CopyOnWrite, handler));

            executor.execute(new SearchList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new SearchList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new SearchList(copyOnWrite, TypeList.CopyOnWrite, handler));

            executor.execute(new RemovingBeginningList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new RemovingBeginningList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new RemovingBeginningList(copyOnWrite, TypeList.CopyOnWrite, handler));

            executor.execute(new RemovingMiddleList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new RemovingMiddleList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new RemovingMiddleList(copyOnWrite, TypeList.CopyOnWrite, handler));
            executor.execute(new RemovingEndList(arrayList, TypeList.ArrayList, handler));
            executor.execute(new RemovingEndList(linkedList, TypeList.LinkedList, handler));
            executor.execute(new RemovingEndList(copyOnWrite, TypeList.CopyOnWrite, handler));
        });
    }

    public void fillingMapEnd(Map<TypeMap, Map<String, Integer>> result) {
        hashMap = (HashMap<String, Integer>) result.get(TypeMap.HashMap);
        treeMap = (TreeMap<String, Integer>) result.get(TypeMap.TreeMap);

        executor.execute(() -> {
            executor.execute(new AddingNewMap(hashMap, TypeMap.HashMap, handler));
            executor.execute(new AddingNewMap(treeMap, TypeMap.TreeMap, handler));
            executor.execute(new RemovingMap(hashMap, TypeMap.HashMap, handler));
            executor.execute(new RemovingMap(treeMap, TypeMap.TreeMap, handler));
            executor.execute(new SearchByKeyMap(hashMap, TypeMap.HashMap, handler));
            executor.execute(new SearchByKeyMap(treeMap, TypeMap.TreeMap, handler));
        });
    }

    @SuppressLint("HandlerLeak")
    private void initHandler() {
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (AddingBeginningAL.getValue() == msg.what) {
                    setListResultNewData(AddingBeginningAL, String.valueOf(msg.arg1));
                } else if (AddingBeginningLL.getValue() == msg.what) {
                    setListResultNewData(AddingBeginningLL, String.valueOf(msg.arg1));
                } else if (AddingBeginningCoW.getValue() == msg.what) {
                    setListResultNewData(AddingBeginningCoW, String.valueOf(msg.arg1));
                } else if (AddingMiddleAL.getValue() == msg.what) {
                    setListResultNewData(AddingMiddleAL, String.valueOf(msg.arg1));
                } else if (AddingMiddleLL.getValue() == msg.what) {
                    setListResultNewData(AddingMiddleLL, String.valueOf(msg.arg1));
                } else if (AddingMiddleCoW.getValue() == msg.what) {
                    setListResultNewData(AddingMiddleCoW, String.valueOf(msg.arg1));
                } else if (AddingEndAL.getValue() == msg.what) {
                    setListResultNewData(AddingEndAL, String.valueOf(msg.arg1));
                } else if (AddingEndLL.getValue() == msg.what) {
                    setListResultNewData(AddingEndLL, String.valueOf(msg.arg1));
                } else if (AddingEndCoW.getValue() == msg.what) {
                    setListResultNewData(AddingEndCoW, String.valueOf(msg.arg1));
                } else if (SearchAL.getValue() == msg.what) {
                    setListResultNewData(SearchAL, String.valueOf(msg.arg1));
                } else if (SearchLL.getValue() == msg.what) {
                    setListResultNewData(SearchLL, String.valueOf(msg.arg1));
                } else if (SearchCoW.getValue() == msg.what) {
                    setListResultNewData(SearchCoW, String.valueOf(msg.arg1));
                } else if (RemovingBeginningAL.getValue() == msg.what) {
                    setListResultNewData(RemovingBeginningAL, String.valueOf(msg.arg1));
                } else if (RemovingBeginningLL.getValue() == msg.what) {
                    setListResultNewData(RemovingBeginningLL, String.valueOf(msg.arg1));
                } else if (RemovingBeginningCoW.getValue() == msg.what) {
                    setListResultNewData(RemovingBeginningCoW, String.valueOf(msg.arg1));
                } else if (RemovingMiddleAL.getValue() == msg.what) {
                    setListResultNewData(RemovingMiddleAL, String.valueOf(msg.arg1));
                } else if (RemovingMiddleLL.getValue() == msg.what) {
                    setListResultNewData(RemovingMiddleLL, String.valueOf(msg.arg1));
                } else if (RemovingMiddleCoW.getValue() == msg.what) {
                    setListResultNewData(RemovingMiddleCoW, String.valueOf(msg.arg1));
                } else if (RemovingEndAL.getValue() == msg.what) {
                    setListResultNewData(RemovingEndAL, String.valueOf(msg.arg1));
                } else if (RemovingEndLL.getValue() == msg.what) {
                    setListResultNewData(RemovingEndLL, String.valueOf(msg.arg1));
                } else if (RemovingEndCoW.getValue() == msg.what) {
                    setListResultNewData(RemovingEndCoW, String.valueOf(msg.arg1));
                } else if (AddingNewHM.getValue() == msg.what) {
                    setMapResultNewData(AddingNewHM, String.valueOf(msg.arg1));
                } else if (AddingNewTM.getValue() == msg.what) {
                    setMapResultNewData(AddingNewTM, String.valueOf(msg.arg1));
                } else if (SearchHM.getValue() == msg.what) {
                    setMapResultNewData(SearchHM, String.valueOf(msg.arg1));
                } else if (SearchTM.getValue() == msg.what) {
                    setMapResultNewData(SearchTM, String.valueOf(msg.arg1));
                } else if (RemovingHM.getValue() == msg.what) {
                    setMapResultNewData(RemovingHM, String.valueOf(msg.arg1));
                } else if (RemovingTM.getValue() == msg.what) {
                    setMapResultNewData(RemovingTM, String.valueOf(msg.arg1));
                } else if (FillingListCompleted.getValue() == msg.what) {
                    fillingListEnd((Map<TypeList, List<Integer>>) msg.obj);
                } else if (FillingMapCompleted.getValue() == msg.what) {
                    fillingMapEnd((Map<TypeMap, Map<String, Integer>>) msg.obj);
                }

            }
        };
    }

    private void setListResultNewData(ListTests test, String data) {
        listResults.put(test, data);
        listDataObserver.get().notifyDataSetChanged();
    }

    private void setMapResultNewData(MapTests test, String data) {
        mapResults.put(test, data);
        mapDataObserver.get().notifyDataSetChanged();
    }

    public void runListTests(Integer size) {
        clearListResult();
        executor.execute(new FillingList(size, handler));
    }

    public void runMapTests(Integer size) {
        clearMapResult();
        executor.execute(new FillingMap(size, handler));
    }

    private void clearListResult() {
        for (ListTests dir : ListTests.values()) {
            listResults.put(dir, " ");
        }
    }

    private void clearMapResult() {
        for (MapTests dir : MapTests.values()) {
            mapResults.put(dir, " ");
        }
    }

    public void setListDataObserver(NotifyDataSetChanged listDataObserver) {
        this.listDataObserver = new WeakReference<>(listDataObserver);
    }

    public void setMapDataObserver(NotifyDataSetChanged mapDataObserver) {
        this.mapDataObserver = new WeakReference<>(mapDataObserver);
    }

    public HashMap<ListTests, String> getListResults() {
        return listResults;
    }

    public HashMap<MapTests, String> getMapResults() {
        return mapResults;
    }


}
