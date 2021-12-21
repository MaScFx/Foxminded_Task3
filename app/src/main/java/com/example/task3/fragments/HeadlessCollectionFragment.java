package com.example.task3.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.task3.model.collectionTests.ICollectionTests;
import com.example.task3.model.constants.TypeList;
import com.example.task3.model.collectionTests.AddingBeginningList;
import com.example.task3.model.collectionTests.AddingEndList;
import com.example.task3.model.collectionTests.AddingMiddleList;
import com.example.task3.model.collectionTests.RemovingBeginningList;
import com.example.task3.model.collectionTests.RemovingEndList;
import com.example.task3.model.collectionTests.RemovingMiddleList;
import com.example.task3.model.collectionTests.SearchList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeadlessCollectionFragment extends Fragment implements ICollectionTests {
    private ExecutorService executor;
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private Handler handler;
    private CopyOnWriteArrayList<Integer> copyOnWrite;
    private final MutableLiveData<String> addingBeginningAL = new MutableLiveData<>();
    private final MutableLiveData<String> addingBeginningLL = new MutableLiveData<>();
    private final MutableLiveData<String> addingBeginningCoW = new MutableLiveData<>();
    private final MutableLiveData<String> addingMiddleAL = new MutableLiveData<>();
    private final MutableLiveData<String> addingMiddleLL = new MutableLiveData<>();
    private final MutableLiveData<String> addingMiddleCoW = new MutableLiveData<>();
    private final MutableLiveData<String> addingEndAL = new MutableLiveData<>();
    private final MutableLiveData<String> addingEndLL = new MutableLiveData<>();
    private final MutableLiveData<String> addingEndCoW = new MutableLiveData<>();
    private final MutableLiveData<String> searchAL = new MutableLiveData<>();
    private final MutableLiveData<String> searchLL = new MutableLiveData<>();
    private final MutableLiveData<String> searchCoW = new MutableLiveData<>();
    private final MutableLiveData<String> removingBeginningAL = new MutableLiveData<>();
    private final MutableLiveData<String> removingBeginningLL = new MutableLiveData<>();
    private final MutableLiveData<String> removingBeginningCoW = new MutableLiveData<>();
    private final MutableLiveData<String> removingMiddleAL = new MutableLiveData<>();
    private final MutableLiveData<String> removingMiddleLL = new MutableLiveData<>();
    private final MutableLiveData<String> removingMiddleCoW = new MutableLiveData<>();
    private final MutableLiveData<String> removingEndAL = new MutableLiveData<>();
    private final MutableLiveData<String> removingEndLL = new MutableLiveData<>();
    private final MutableLiveData<String> removingEndCoW = new MutableLiveData<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        clearResult();

    }

    public void runTasks(Integer size) {
        clearResult();
        new Thread(() -> {
            initLists(size);
            executor.execute(new AddingBeginningList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new AddingBeginningList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new AddingBeginningList(copyOnWrite, TypeList.CopyOnWrite, handler, this));

            executor.execute(new AddingMiddleList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new AddingMiddleList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new AddingMiddleList(copyOnWrite, TypeList.CopyOnWrite, handler, this));

            executor.execute(new AddingEndList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new AddingEndList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new AddingEndList(copyOnWrite, TypeList.CopyOnWrite, handler, this));

            executor.execute(new SearchList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new SearchList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new SearchList(copyOnWrite, TypeList.CopyOnWrite, handler, this));

            executor.execute(new RemovingBeginningList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new RemovingBeginningList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new RemovingBeginningList(copyOnWrite, TypeList.CopyOnWrite, handler, this));

            executor.execute(new RemovingMiddleList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new RemovingMiddleList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new RemovingMiddleList(copyOnWrite, TypeList.CopyOnWrite, handler, this));
            executor.execute(new RemovingEndList(arrayList, TypeList.ArrayList, handler, this));
            executor.execute(new RemovingEndList(linkedList, TypeList.LinkedList, handler, this));
            executor.execute(new RemovingEndList(copyOnWrite, TypeList.CopyOnWrite, handler, this));
        }).start();
    }

    private void initLists(Integer size) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        linkedList = new LinkedList<>(arrayList);
        copyOnWrite = new CopyOnWriteArrayList<>(arrayList);
    }

    private void clearResult() {
        for (MutableLiveData<String> data : Arrays.asList(
                addingBeginningAL,
                addingBeginningLL,
                addingBeginningCoW,
                addingMiddleAL,
                addingMiddleLL,
                addingMiddleCoW,
                addingEndAL,
                addingEndLL,
                addingEndCoW,
                searchAL,
                searchLL,
                searchCoW,
                removingBeginningAL,
                removingBeginningLL,
                removingBeginningCoW,
                removingMiddleAL,
                removingMiddleLL,
                removingMiddleCoW,
                removingEndAL,
                removingEndLL,
                removingEndCoW)) {
            data.setValue(" ");
        }
    }

    @Override
    public void setAddingBeginningALResult(String result) {
        addingBeginningAL.setValue(result);
    }

    @Override
    public void setAddingBeginningLLResult(String result) {
        addingBeginningLL.setValue(result);
    }

    @Override
    public void setAddingBeginningCoWResult(String result) {
        addingBeginningCoW.setValue(result);
    }

    @Override
    public void setAddingMiddleALResult(String result) {
        addingMiddleAL.setValue(result);
    }

    @Override
    public void setAddingMiddleLLResult(String result) {
        addingMiddleLL.setValue(result);
    }

    @Override
    public void setAddingMiddleCoWResult(String result) {
        addingMiddleCoW.setValue(result);
    }

    @Override
    public void setAddingEndALResult(String result) {
        addingEndAL.setValue(result);
    }

    @Override
    public void setAddingEndLLResult(String result) {
        addingEndLL.setValue(result);
    }

    @Override
    public void setAddingEndCoWResult(String result) {
        addingEndCoW.setValue(result);
    }

    @Override
    public void setSearchALResult(String result) {
        searchAL.setValue(result);
    }

    @Override
    public void setSearchLLResult(String result) {
        searchLL.setValue(result);
    }

    @Override
    public void setSearchCoWResult(String result) {
        searchCoW.setValue(result);
    }

    @Override
    public void setRemovingBeginningALResult(String result) {
        removingBeginningAL.setValue(result);
    }

    @Override
    public void setRemovingBeginningLLResult(String result) {
        removingBeginningLL.setValue(result);
    }

    @Override
    public void setRemovingBeginningCoWResult(String result) {
        removingBeginningCoW.setValue(result);
    }

    @Override
    public void setRemovingMiddleALResult(String result) {
        removingMiddleAL.setValue(result);
    }

    @Override
    public void setRemovingMiddleLLResult(String result) {
        removingMiddleLL.setValue(result);
    }

    @Override
    public void setRemovingMiddleCoWResult(String result) {
        removingMiddleCoW.setValue(result);
    }

    @Override
    public void setRemovingEndALResult(String result) {
        removingEndAL.setValue(result);
    }

    @Override
    public void setRemovingEndLLResult(String result) {
        removingEndLL.setValue(result);
    }

    @Override
    public void setRemovingEndCoWResult(String result) {
        removingEndCoW.setValue(result);
    }

    public LiveData<String> getAddingBeginningAL() {
        return addingBeginningAL;
    }

    public LiveData<String> getAddingBeginningLL() {
        return addingBeginningLL;
    }

    public LiveData<String> getAddingBeginningCoW() {
        return addingBeginningCoW;
    }

    public LiveData<String> getAddingMiddleAL() {
        return addingMiddleAL;
    }

    public LiveData<String> getAddingMiddleLL() {
        return addingMiddleLL;
    }

    public LiveData<String> getAddingMiddleCoW() {
        return addingMiddleCoW;
    }

    public LiveData<String> getAddingEndAL() {
        return addingEndAL;
    }

    public LiveData<String> getAddingEndLL() {
        return addingEndLL;
    }

    public LiveData<String> getAddingEndCoW() {
        return addingEndCoW;
    }

    public LiveData<String> getSearchAL() {
        return searchAL;
    }

    public LiveData<String> getSearchLL() {
        return searchLL;
    }

    public LiveData<String> getSearchCoW() {
        return searchCoW;
    }

    public LiveData<String> getRemovingBeginningAL() {
        return removingBeginningAL;
    }

    public LiveData<String> getRemovingBeginningLL() {
        return removingBeginningLL;
    }

    public LiveData<String> getRemovingBeginningCoW() {
        return removingBeginningCoW;
    }

    public LiveData<String> getRemovingMiddleAL() {
        return removingMiddleAL;
    }

    public LiveData<String> getRemovingMiddleLL() {
        return removingMiddleLL;
    }

    public LiveData<String> getRemovingMiddleCoW() {
        return removingMiddleCoW;
    }

    public LiveData<String> getRemovingEndAL() {
        return removingEndAL;
    }

    public LiveData<String> getRemovingEndLL() {
        return removingEndLL;
    }

    public LiveData<String> getRemovingEndCoW() {
        return removingEndCoW;
    }
}
