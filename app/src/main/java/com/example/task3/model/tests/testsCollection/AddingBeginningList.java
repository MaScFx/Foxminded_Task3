package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.AddingBeginningAL;
import static com.example.task3.model.constants.ListTest.AddingBeginningCoW;
import static com.example.task3.model.constants.ListTest.AddingBeginningLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingBeginningList extends BaseListTestClass {


    public AddingBeginningList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }

    public AddingBeginningList(List<Integer> list, TypeList typeList) {
        super(list, typeList);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(AddingBeginningAL.getValue(), (int) finalTime, 0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(AddingBeginningLL.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingBeginningCoW.getValue(), (int) finalTime, 0));
        }

    }
}
