package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.RemovingEndAL;
import static com.example.task3.model.constants.ListTest.RemovingEndCoW;
import static com.example.task3.model.constants.ListTest.RemovingEndLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingEndList extends BaseListTestClass {

    public RemovingEndList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }

    public RemovingEndList(List<Integer> list, TypeList typeList) {
        super(list, typeList);
    }

    @Override
    public void run() {
        long finalTime;
        synchronized (list) {
            int size = list.size();
            long startTime = System.currentTimeMillis();
            list.remove(size - 1);
            finalTime = System.currentTimeMillis() - startTime;
        }

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(RemovingEndAL.getValue(), (int) finalTime, 0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(RemovingEndLL.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingEndCoW.getValue(), (int) finalTime, 0));
        }
    }
}
