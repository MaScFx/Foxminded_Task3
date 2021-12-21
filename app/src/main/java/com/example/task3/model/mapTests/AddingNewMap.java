package com.example.task3.model.mapTests;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class AddingNewMap implements Runnable {

    private final Map<String, Integer> map;
    private final TypeMap typeMap;
    private final Handler handler;
    private final IMapTests iMapTests;

    public AddingNewMap(Map<String, Integer> map, TypeMap typeMap, Handler handler, IMapTests iMapTests) {
        this.handler = handler;
        this.map = map;
        this.typeMap = typeMap;
        this.iMapTests = iMapTests;
    }

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.put("key " + size, size);
        long finalTime = System.currentTimeMillis() - startTime;
        handler.post(() -> {
            if (typeMap.equals(TypeMap.HashMap)) {
                iMapTests.setAddingNewHashMapResult(String.valueOf(finalTime));
            } else {
                iMapTests.setAddingNewTreeMapResult(String.valueOf(finalTime));
            }
        });

    }
}
