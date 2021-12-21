package com.example.task3.model.collectionTests;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingEndList implements Runnable {
    public RemovingEndList(List<Integer> list, TypeList typeList, Handler handler, ICollectionTests collectionTests) {
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
        list.remove(size - 1);
        long finalTime = System.currentTimeMillis() - startTime;
        handler.post(() -> {
            if (typeList.equals(TypeList.ArrayList)) {
                collectionTests.setRemovingEndALResult(String.valueOf(finalTime));
            } else if (typeList.equals(TypeList.LinkedList)) {
                collectionTests.setRemovingEndLLResult(String.valueOf(finalTime));
            } else {
                collectionTests.setRemovingEndCoWResult(String.valueOf(finalTime));
            }
        });
    }
}
