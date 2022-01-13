package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.RemovingBeginningAL;
import static com.example.task3.model.constants.ListTest.RemovingBeginningCoW;
import static com.example.task3.model.constants.ListTest.RemovingBeginningLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class RemovingBeginningList extends BaseListTestClass {

    public RemovingBeginningList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }

    public RemovingBeginningList(List<Integer> list, TypeList typeList) {
        super(list, typeList);
    }

    @Override
    public void run() {
        long finalTime;
        synchronized (list) {
            long startTime = System.currentTimeMillis();
            list.remove(0);
            finalTime = System.currentTimeMillis() - startTime;
        }

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(RemovingBeginningAL.getValue(), (int) finalTime, 0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(RemovingBeginningLL.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingBeginningCoW.getValue(), (int) finalTime, 0));
        }
    }
}
