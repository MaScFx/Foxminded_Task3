package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingEndAL;

import java.util.List;

public class AddingEndAL extends BaseListOperationClass {

    public AddingEndAL(List<Integer> list) {
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

        handler.sendMessage(handler.obtainMessage(AddingEndAL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingEndAL.ordinal();
    }
}
