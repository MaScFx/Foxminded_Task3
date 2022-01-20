package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingEndLL;

import java.util.List;

public class AddingEndLL extends BaseListOperationClass {

    public AddingEndLL(List<Integer> list) {
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

        handler.sendMessage(handler.obtainMessage(AddingEndLL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingEndLL.ordinal();
    }
}

