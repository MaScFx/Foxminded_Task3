package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingMiddleCoW;

import java.util.List;

public class AddingMiddleCoW extends BaseListOperationClass {

    public AddingMiddleCoW(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        int size = list.size();
        long startTime = System.currentTimeMillis();
        list.add(size / 2, size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(AddingMiddleCoW.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingMiddleCoW.ordinal();
    }
}
