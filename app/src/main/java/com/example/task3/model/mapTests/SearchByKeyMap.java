package com.example.task3.model.mapTests;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class SearchByKeyMap implements Runnable {
    private final Handler handler;
    private final Map<String, Integer> map;
    private final TypeMap typeMap;
    private final IMapTests iMapTests;

    public SearchByKeyMap(Map<String, Integer> map, TypeMap typeMap, Handler handler, IMapTests iMapTests) {
        this.handler = handler;
        this.map = map;
        this.typeMap = typeMap;
        this.iMapTests = iMapTests;
    }

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.get("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;
        handler.post(() -> {
            if (typeMap.equals(TypeMap.HashMap)) {
                iMapTests.setSearchByKeyHashMapResult(String.valueOf(finalTime));
            } else {
                iMapTests.setSearchByKeyTreeMapResult(String.valueOf(finalTime));
            }
        });

    }
}
