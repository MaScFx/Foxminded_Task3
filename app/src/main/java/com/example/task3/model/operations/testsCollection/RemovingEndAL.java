package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.RemovingEndAL;

import java.util.List;

public class RemovingEndAL extends BaseListOperationClass {

    public RemovingEndAL(List<Integer> list) {
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

        handler.sendMessage(handler.obtainMessage(RemovingEndAL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingEndAL.ordinal();
    }
}
