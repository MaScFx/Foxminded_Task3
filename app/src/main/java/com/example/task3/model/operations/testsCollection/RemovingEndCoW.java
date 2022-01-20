package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.RemovingEndCoW;

import java.util.List;

public class RemovingEndCoW extends BaseListOperationClass {

    public RemovingEndCoW(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long finalTime;

        synchronized (list) {
            int size = list.size();
            long startTime = System.currentTimeMillis();
            list.remove(size - 1);
            finalTime = System.currentTimeMillis() - startTime;
        }

        handler.sendMessage(handler.obtainMessage(RemovingEndCoW.ordinal(), (int) finalTime, 0));

    }

    @Override
    public Integer getIDOperation() {
        return RemovingEndCoW.ordinal();
    }
}

