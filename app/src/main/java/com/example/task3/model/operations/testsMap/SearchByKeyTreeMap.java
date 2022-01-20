package com.example.task3.model.operations.testsMap;

import static com.example.task3.model.constants.Operations.SearchTM;


import java.util.Map;

public class SearchByKeyTreeMap extends BaseMapOperationClass {

    public SearchByKeyTreeMap(Map<String, Integer> map) {
        super(map);
    }

    @Override
    public void run() {
        int size = map.size();

        long startTime = System.currentTimeMillis();
        map.get("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(SearchTM.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return SearchTM.ordinal();
    }

}
