package com.example.task3.model.operations.testsCollection;


import static com.example.task3.model.constants.Operations.RemovingBeginningCoW;


import java.util.List;

public class RemovingBeginningCoW extends BaseListOperationClass {

    public RemovingBeginningCoW(List<Integer> list) {
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

        handler.sendMessage(handler.obtainMessage(RemovingBeginningCoW.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingBeginningCoW.ordinal();
    }
}
