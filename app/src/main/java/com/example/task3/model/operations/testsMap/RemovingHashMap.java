package com.example.task3.model.operations.testsMap;


import static com.example.task3.model.constants.Operations.RemovingHM;


import java.util.Map;

public class RemovingHashMap extends BaseMapOperationClass {

    public RemovingHashMap(Map<String, Integer> map) {
        super(map);
    }

    @Override
    public void run() {
        int size = map.size();

        long startTime = System.currentTimeMillis();
        map.remove("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(RemovingHM.ordinal(), (int) finalTime, 0));
    }
    @Override
    public Integer getIDOperation() {
        return RemovingHM.ordinal();
    }
}
