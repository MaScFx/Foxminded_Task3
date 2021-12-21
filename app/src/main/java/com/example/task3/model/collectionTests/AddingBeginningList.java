package com.example.task3.model.collectionTests;


import android.os.Handler;


import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingBeginningList implements Runnable {
    public AddingBeginningList(List<Integer> list, TypeList typeList, Handler handler, ICollectionTests collectionTests) {
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
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;
        handler.post(() -> {
            if (typeList.equals(TypeList.ArrayList)) {
                collectionTests.setAddingBeginningALResult(String.valueOf(finalTime));
            } else if (typeList.equals(TypeList.LinkedList)) {
                collectionTests.setAddingBeginningLLResult(String.valueOf(finalTime));
            } else {
                collectionTests.setAddingBeginningCoWResult(String.valueOf(finalTime));
            }
        });


    }
}
