package com.example.task3.model.operations.testsMap;

import android.os.Handler;

import com.example.task3.model.operations.IOperation;

import java.util.Map;

public abstract class BaseMapOperationClass implements IOperation {

    public BaseMapOperationClass(Map<String, Integer> map) {
        this.map = map;
    }

    protected final Map<String, Integer> map;
    protected Handler handler;

    @Override
    public void run() {

    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
