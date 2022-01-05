package com.example.task3.model.testsCollection;

import static com.example.task3.model.constants.ListTests.AddingBeginningAL;
import static com.example.task3.model.constants.ListTests.AddingBeginningCoW;
import static com.example.task3.model.constants.ListTests.AddingBeginningLL;

import android.os.Handler;


import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingBeginningList implements Runnable {
    public AddingBeginningList(List<Integer> list, TypeList typeList, Handler handler) {
        this.handler = handler;
        this.list = list;
        this.typeList = typeList;
    }

    private final Handler handler;
    private final List<Integer> list;
    private final TypeList typeList;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(AddingBeginningAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(AddingBeginningLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingBeginningCoW.getValue(), (int) finalTime,0));
        }

    }
}
