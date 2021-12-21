package com.example.task3.model.collectionTests;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingBeginningList implements Runnable {
    public RemovingBeginningList(List<Integer> list, TypeList typeList, Handler handler, ICollectionTests collectionTests) {
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
        long startTime = System.currentTimeMillis();
        list.remove(0);
        long finalTime = System.currentTimeMillis() - startTime;
        handler.post(() -> {
            if (typeList.equals(TypeList.ArrayList)) {
                collectionTests.setRemovingBeginningALResult(String.valueOf(finalTime));
            } else if (typeList.equals(TypeList.LinkedList)) {
                collectionTests.setRemovingBeginningLLResult(String.valueOf(finalTime));
            } else {
                collectionTests.setRemovingBeginningCoWResult(String.valueOf(finalTime));
            }
        });
    }
}
