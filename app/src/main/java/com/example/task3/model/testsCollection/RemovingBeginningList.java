package com.example.task3.model.testsCollection;

import static com.example.task3.model.constants.ListTests.RemovingBeginningAL;
import static com.example.task3.model.constants.ListTests.RemovingBeginningCoW;
import static com.example.task3.model.constants.ListTests.RemovingBeginningLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingBeginningList implements Runnable {
    public RemovingBeginningList(List<Integer> list, TypeList typeList, Handler handler) {
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
        list.remove(0);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(RemovingBeginningAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(RemovingBeginningLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingBeginningCoW.getValue(), (int) finalTime,0));
        }
    }
}
