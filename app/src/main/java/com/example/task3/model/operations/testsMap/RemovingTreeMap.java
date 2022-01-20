package com.example.task3.model.operations.testsMap;

import static com.example.task3.model.constants.Operations.RemovingTM;


import java.util.Map;

public class RemovingTreeMap extends BaseMapOperationClass {

    public RemovingTreeMap(Map<String, Integer> map) {
        super(map);
    }

    @Override
    public void run() {
        int size = map.size();

        long startTime = System.currentTimeMillis();
        map.remove("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(RemovingTM.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return RemovingTM.ordinal();
    }
}
