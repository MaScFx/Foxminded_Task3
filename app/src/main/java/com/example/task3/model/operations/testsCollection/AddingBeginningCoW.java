package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.AddingBeginningCoW;

import java.util.List;

public class AddingBeginningCoW extends BaseListOperationClass {

    public AddingBeginningCoW(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(AddingBeginningCoW.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingBeginningCoW.ordinal();
    }
}
