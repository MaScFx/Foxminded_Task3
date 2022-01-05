package com.example.task3.model.testsCollection;

import static com.example.task3.model.constants.ListTests.AddingEndAL;
import static com.example.task3.model.constants.ListTests.AddingEndCoW;
import static com.example.task3.model.constants.ListTests.AddingEndLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingEndList implements Runnable {
    public AddingEndList(List<Integer> list, TypeList typeList, Handler handler) {
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
        list.add(size - 1, size);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(AddingEndAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(AddingEndLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingEndCoW.getValue(), (int) finalTime,0));
        }

    }
}
