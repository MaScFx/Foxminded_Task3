package com.example.task3.model.collectionTests;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingMiddleList implements Runnable {
    public AddingMiddleList(List<Integer> list, TypeList typeList, Handler handler, ICollectionTests collectionTests) {
        this.handler = handler;
        this.list = list;
        this.typeList = typeList;
        this.collectionTests = collectionTests;
    }

    private final Handler handler;
    private final List<Integer> list;
    private final TypeList typeList;
    private final ICollectionTests collectionTests;

    @Override
    public void run() {
        int size = list.size();
        long startTime = System.currentTimeMillis();
        list.add(size / 2, size / 2);
        long finalTime = System.currentTimeMillis() - startTime;
        handler.post(() -> {
            if (typeList.equals(TypeList.ArrayList)) {
                collectionTests.setAddingMiddleALResult(String.valueOf(finalTime));
            } else if (typeList.equals(TypeList.LinkedList)) {
                collectionTests.setAddingMiddleLLResult(String.valueOf(finalTime));
            } else {
                collectionTests.setAddingMiddleCoWResult(String.valueOf(finalTime));
            }
        });
    }
}
