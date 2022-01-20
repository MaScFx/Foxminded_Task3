package com.example.task3.model.operations.testsCollection;

import android.os.Handler;

import com.example.task3.model.operations.IOperation;

import java.util.List;

public abstract class BaseListOperationClass implements IOperation {

    public BaseListOperationClass(List<Integer> list) {
        this.list = list;
    }

    protected Handler handler;
    protected final List<Integer> list;

    @Override
    public void run() {
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
