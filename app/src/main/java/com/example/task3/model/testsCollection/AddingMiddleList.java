package com.example.task3.model.testsCollection;


import static com.example.task3.model.constants.ListTests.AddingMiddleAL;
import static com.example.task3.model.constants.ListTests.AddingMiddleCoW;
import static com.example.task3.model.constants.ListTests.AddingMiddleLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingMiddleList implements Runnable {
    public AddingMiddleList(List<Integer> list, TypeList typeList, Handler handler) {
        this.handler = handler;
        this.list = list;
        this.typeList = typeList;
    }

    private final Handler handler;
    private final List<Integer> list;
    private final TypeList typeList;

    @Override
    public void run() {
        int size = list.size();
        long startTime = System.currentTimeMillis();
        list.add(size / 2, size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(AddingMiddleAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(AddingMiddleLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingMiddleCoW.getValue(), (int) finalTime,0));
        }
    }
}
