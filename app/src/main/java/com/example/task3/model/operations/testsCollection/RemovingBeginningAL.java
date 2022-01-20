package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.RemovingBeginningAL;

import java.util.List;

public class RemovingBeginningAL extends BaseListOperationClass {

    public RemovingBeginningAL(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long finalTime;
        synchronized (list) {
            long startTime = System.currentTimeMillis();
            list.remove(0);
            finalTime = System.currentTimeMillis() - startTime;
        }

        handler.sendMessage(handler.obtainMessage(RemovingBeginningAL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingBeginningAL.ordinal();
    }
}
