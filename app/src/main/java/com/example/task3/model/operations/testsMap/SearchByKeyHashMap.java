package com.example.task3.model.operations.testsMap;

import static com.example.task3.model.constants.Operations.SearchHM;


import java.util.Map;

public class SearchByKeyHashMap extends BaseMapOperationClass {

    public SearchByKeyHashMap(Map<String, Integer> map) {
        super(map);
    }

    @Override
    public void run() {
        int size = map.size();

        long startTime = System.currentTimeMillis();
        map.get("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(SearchHM.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return SearchHM.ordinal();
    }
}
