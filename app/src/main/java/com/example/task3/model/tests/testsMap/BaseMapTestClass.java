package com.example.task3.model.tests.testsMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;
import com.example.task3.model.tests.iTest;

import java.util.Map;

public class BaseMapTestClass implements Runnable, iTest {

    public BaseMapTestClass(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
        this.handler = handler;
        this.map = map;
        this.typeMap = typeMap;
    }

    public BaseMapTestClass(Map<String, Integer> map, TypeMap typeMap) {
        this.map = map;
        this.typeMap = typeMap;
    }

    protected final Map<String, Integer> map;
    protected final TypeMap typeMap;
    protected Handler handler;

    @Override
    public void run() {

    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
