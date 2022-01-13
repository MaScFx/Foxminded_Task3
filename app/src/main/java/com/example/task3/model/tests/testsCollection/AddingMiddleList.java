package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.AddingMiddleAL;
import static com.example.task3.model.constants.ListTest.AddingMiddleCoW;
import static com.example.task3.model.constants.ListTest.AddingMiddleLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingMiddleList extends BaseListTestClass {

    public AddingMiddleList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }

    public AddingMiddleList(List<Integer> list, TypeList typeList) {
        super(list, typeList);
    }

    @Override
    public void run() {
        int size = list.size();
        long startTime = System.currentTimeMillis();
        list.add(size / 2, size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(AddingMiddleAL.getValue(), (int) finalTime, 0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(AddingMiddleLL.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingMiddleCoW.getValue(), (int) finalTime, 0));
        }
    }
}
