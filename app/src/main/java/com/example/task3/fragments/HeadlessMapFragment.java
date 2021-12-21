package com.example.task3.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.task3.model.constants.TypeMap;
import com.example.task3.model.mapTests.AddingNewMap;
import com.example.task3.model.mapTests.IMapTests;
import com.example.task3.model.mapTests.RemovingMap;
import com.example.task3.model.mapTests.SearchByKeyMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeadlessMapFragment extends Fragment implements IMapTests {

    private ExecutorService executor;
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private TreeMap<String, Integer> treeMap = new TreeMap<>();
    private Handler handler;
    private final MutableLiveData<String> AddingNewHashMap = new MutableLiveData<>();
    private final MutableLiveData<String> AddingNewTreeMap = new MutableLiveData<>();
    private final MutableLiveData<String> SearchByKeyHashMap = new MutableLiveData<>();
    private final MutableLiveData<String> SearchByKeyTreeMap = new MutableLiveData<>();
    private final MutableLiveData<String> RemovingHashMap = new MutableLiveData<>();
    private final MutableLiveData<String> RemovingTreeMap = new MutableLiveData<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        clearResult();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        for (MutableLiveData<String> data : Arrays.asList(
                AddingNewHashMap,
                AddingNewTreeMap,
                SearchByKeyHashMap,
                SearchByKeyTreeMap,
                RemovingHashMap,
                RemovingTreeMap)) {
            data.setValue(" ");
        }
    }

    public void runTasks(Integer size) {
        clearResult();
        new Thread(() -> {
            initLists(size);
            executor.execute(new AddingNewMap(hashMap, TypeMap.HashMap, handler, this));
            executor.execute(new AddingNewMap(treeMap, TypeMap.TreeMap, handler, this));
            executor.execute(new RemovingMap(hashMap, TypeMap.HashMap, handler, this));
            executor.execute(new RemovingMap(treeMap, TypeMap.TreeMap, handler, this));
            executor.execute(new SearchByKeyMap(hashMap, TypeMap.HashMap, handler, this));
            executor.execute(new SearchByKeyMap(treeMap, TypeMap.TreeMap, handler, this));
        }).start();
    }

    private void initLists(Integer size) {
        for (int i = 0; i < size; i++) {
            hashMap.put("key " + i, i);
            treeMap.put("key " + i, i);
        }
    }

    private void clearResult() {
        for (MutableLiveData<String> data : Arrays.asList(
                AddingNewHashMap,
                AddingNewTreeMap,
                SearchByKeyHashMap,
                SearchByKeyTreeMap,
                RemovingHashMap,
                RemovingTreeMap)) {
            data.setValue(" ");
        }
    }

    @Override
    public void setAddingNewHashMapResult(String result) {
        AddingNewHashMap.setValue(result);
    }

    @Override
    public void setAddingNewTreeMapResult(String result) {
        AddingNewTreeMap.setValue(result);

    }

    @Override
    public void setSearchByKeyHashMapResult(String result) {
        SearchByKeyHashMap.setValue(result);

    }

    @Override
    public void setSearchByKeyTreeMapResult(String result) {
        SearchByKeyTreeMap.setValue(result);

    }

    @Override
    public void setRemovingHashMapResult(String result) {
        RemovingHashMap.setValue(result);

    }

    @Override
    public void setRemovingTreeMapResult(String result) {
        RemovingTreeMap.setValue(result);

    }

    public LiveData<String> getAddingNewHashMap() {
        return AddingNewHashMap;
    }

    public LiveData<String> getAddingNewTreeMap() {
        return AddingNewTreeMap;
    }

    public LiveData<String> getSearchByKeyHashMap() {
        return SearchByKeyHashMap;
    }

    public LiveData<String> getSearchByKeyTreeMap() {
        return SearchByKeyTreeMap;
    }

    public LiveData<String> getRemovingHashMap() {
        return RemovingHashMap;
    }

    public LiveData<String> getRemovingTreeMap() {
        return RemovingTreeMap;
    }
}


