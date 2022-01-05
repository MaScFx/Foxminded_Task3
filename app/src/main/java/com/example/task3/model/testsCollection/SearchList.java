package com.example.task3.model.testsCollection;

import static com.example.task3.model.constants.ListTests.SearchAL;
import static com.example.task3.model.constants.ListTests.SearchCoW;
import static com.example.task3.model.constants.ListTests.SearchLL;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.List;

public class SearchList implements Runnable {
    public SearchList(List<Integer> list, TypeList typeList, Handler handler) {
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
        list.indexOf(size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeList.equals(TypeList.ArrayList)) {
            handler.sendMessage(handler.obtainMessage(SearchAL.getValue(), (int) finalTime,0));
        } else if (typeList.equals(TypeList.LinkedList)) {
            handler.sendMessage(handler.obtainMessage(SearchLL.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(SearchCoW.getValue(), (int) finalTime,0));
        }
    }
}
