package com.example.task3.model.tests.testsCollection;

import static com.example.task3.model.constants.ListTest.SearchAL;
import static com.example.task3.model.constants.ListTest.SearchCoW;
import static com.example.task3.model.constants.ListTest.SearchLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class SearchList extends BaseListTestClass {

    public SearchList(List<Integer> list, TypeList typeList, Handler handler) {
        super(list, typeList, handler);
    }

    public SearchList(List<Integer> list, TypeList typeList) {
        super(list, typeList);
    }

    @Override
    public void run() {
        int size = list.size();
        long startTime = System.currentTimeMillis();
        list.indexOf(size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(SearchAL.getValue(), (int) finalTime, 0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(SearchLL.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(SearchCoW.getValue(), (int) finalTime, 0));
        }
    }
}
