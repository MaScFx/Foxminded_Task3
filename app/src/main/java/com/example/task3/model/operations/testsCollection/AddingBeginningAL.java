package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingBeginningAL;

import java.util.List;

public class AddingBeginningAL extends BaseListOperationClass {

    public AddingBeginningAL(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(AddingBeginningAL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingBeginningAL.ordinal();
    }
}
