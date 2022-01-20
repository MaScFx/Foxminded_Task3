package com.example.task3.model.operations.testsMap;

import static com.example.task3.model.constants.Operations.AddingNewTM;

import java.util.Map;

public class AddingNewTreeMap extends BaseMapOperationClass {

    public AddingNewTreeMap(Map<String, Integer> map) {
        super(map);
    }

    @Override
    public void run() {
        int size = map.size();

        long startTime = System.currentTimeMillis();
        map.put("key " + size, size);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(AddingNewTM.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return AddingNewTM.ordinal();
    }
}
