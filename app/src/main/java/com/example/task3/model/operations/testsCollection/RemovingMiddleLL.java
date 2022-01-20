package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.RemovingMiddleLL;

import java.util.List;

public class RemovingMiddleLL extends BaseListOperationClass {

    public RemovingMiddleLL(List<Integer> list) {
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

        handler.sendMessage(handler.obtainMessage(RemovingMiddleLL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingMiddleLL.ordinal();
    }
}
