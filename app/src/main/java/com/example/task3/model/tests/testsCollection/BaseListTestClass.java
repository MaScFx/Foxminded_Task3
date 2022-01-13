package com.example.task3.model.tests.testsCollection;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;
import com.example.task3.model.tests.iTest;

import java.util.List;

public class BaseListTestClass implements Runnable, iTest {

    public BaseListTestClass(List<Integer> list, TypeList typeList, Handler handler) {
        this.handler = handler;
        this.list = list;
        this.typeList = typeList;
    }

    public BaseListTestClass(List<Integer> list, TypeList typeList) {
        this.list = list;
        this.typeList = typeList;
    }

    protected Handler handler;
    protected final List<Integer> list;
    protected final TypeList typeList;

    @Override
    public void run() {
    }


    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
