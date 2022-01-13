package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.RemovingMiddleAL;
import static com.example.task3.model.constants.ListTest.RemovingMiddleCoW;
import static com.example.task3.model.constants.ListTest.RemovingMiddleLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingMiddleList extends BaseListTestClass {

    public RemovingMiddleList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }

    public RemovingMiddleList(List<Integer> list, TypeList typeList) {
        super(list, typeList);
    }

    @Override
    public void run() {
        long finalTime;
        synchronized (list) {
            int size = list.size();
            long startTime = System.currentTimeMillis();
            list.remove(size / 2);
            finalTime = System.currentTimeMillis() - startTime;
        }

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(RemovingMiddleAL.getValue(), (int) finalTime, 0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(RemovingMiddleLL.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingMiddleCoW.getValue(), (int) finalTime, 0));
        }
    }
}
