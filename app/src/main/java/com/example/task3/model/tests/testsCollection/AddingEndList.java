package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.AddingEndAL;
import static com.example.task3.model.constants.ListTest.AddingEndCoW;
import static com.example.task3.model.constants.ListTest.AddingEndLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class AddingEndList extends BaseListTestClass {

    public AddingEndList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }
    public AddingEndList(List<Integer> list, TypeList typeList) {
        super(list,typeList);
    }

    @Override
    public void run() {
        long finalTime;
        synchronized (list){
            int size = list.size();
            long startTime = System.currentTimeMillis();
            list.add(size - 1, size);
            finalTime = System.currentTimeMillis() - startTime;
        }

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(AddingEndAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(AddingEndLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingEndCoW.getValue(), (int) finalTime,0));
        }

    }
}
