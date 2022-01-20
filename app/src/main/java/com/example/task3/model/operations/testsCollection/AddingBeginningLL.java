package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingBeginningLL;

import java.util.List;

public class AddingBeginningLL extends BaseListOperationClass {

    public AddingBeginningLL(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(AddingBeginningLL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingBeginningLL.ordinal();
    }
}
