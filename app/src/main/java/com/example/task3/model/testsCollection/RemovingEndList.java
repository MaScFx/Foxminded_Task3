package com.example.task3.model.testsCollection;

import static com.example.task3.model.constants.ListTests.RemovingEndAL;
import static com.example.task3.model.constants.ListTests.RemovingEndCoW;
import static com.example.task3.model.constants.ListTests.RemovingEndLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingEndList implements Runnable {
    public RemovingEndList(List<Integer> list, TypeList typeList, Handler handler) {
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
        list.remove(size - 1);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(RemovingEndAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(RemovingEndLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingEndCoW.getValue(), (int) finalTime,0));
        }
    }
}
