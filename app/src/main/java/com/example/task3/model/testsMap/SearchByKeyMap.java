package com.example.task3.model.testsMap;

import static com.example.task3.model.constants.MapTests.SearchHM;
import static com.example.task3.model.constants.MapTests.SearchTM;
import static com.example.task3.model.constants.TypeMap.HashMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class SearchByKeyMap implements Runnable {
    public SearchByKeyMap(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
        this.handler = handler;
        this.map = map;
        this.typeMap = typeMap;
    }

    private final Handler handler;
    private final Map<String, Integer> map;
    private final TypeMap typeMap;

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.get("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeMap.equals(HashMap)) {
            handler.sendMessage(handler.obtainMessage(SearchHM.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(SearchTM.getValue(), (int) finalTime,0));
        }

    }
}
