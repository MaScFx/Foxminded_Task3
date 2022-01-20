package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.RemovingMiddleAL;

import java.util.List;

public class RemovingMiddleAL extends BaseListOperationClass {

    public RemovingMiddleAL(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long finalTime;

        synchronized (list) {
            int size = list.size();
            long startTime = System.currentTimeMillis();
            list.remove(size / 2);
            finalTime = System.currentTimeMillis() - startTime;
        }

        handler.sendMessage(handler.obtainMessage(RemovingMiddleAL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingMiddleAL.ordinal();
    }
}
