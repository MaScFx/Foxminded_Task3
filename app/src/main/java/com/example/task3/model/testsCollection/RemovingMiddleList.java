package com.example.task3.model.testsCollection;

import static com.example.task3.model.constants.ListTests.RemovingMiddleAL;
import static com.example.task3.model.constants.ListTests.RemovingMiddleCoW;
import static com.example.task3.model.constants.ListTests.RemovingMiddleLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingMiddleList implements Runnable {
    public RemovingMiddleList(List<Integer> list, TypeList typeList, Handler handler) {
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
        list.remove(size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(RemovingMiddleAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(RemovingMiddleLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingMiddleCoW.getValue(), (int) finalTime,0));
        }
    }
}
