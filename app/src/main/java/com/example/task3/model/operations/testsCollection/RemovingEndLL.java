package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.RemovingEndLL;

import java.util.List;

public class RemovingEndLL extends BaseListOperationClass {

    public RemovingEndLL(List<Integer> list) {
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

        handler.sendMessage(handler.obtainMessage(RemovingEndLL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingEndLL.ordinal();
    }
}
