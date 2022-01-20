package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingEndCoW;

import java.util.List;

public class AddingEndCoW extends BaseListOperationClass {

    public AddingEndCoW(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long finalTime;

        synchronized (list) {
            int size = list.size();
            long startTime = System.currentTimeMillis();
            list.add(size - 1, size);
            finalTime = System.currentTimeMillis() - startTime;
        }

        handler.sendMessage(handler.obtainMessage(AddingEndCoW.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingEndCoW.ordinal();
    }
}
