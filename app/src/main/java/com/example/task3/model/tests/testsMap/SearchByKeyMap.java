package com.example.task3.model.tests.testsMap;

import static com.example.task3.model.constants.MapTest.SearchHM;
import static com.example.task3.model.constants.MapTest.SearchTM;
import static com.example.task3.model.constants.TypeMap.HashMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class SearchByKeyMap extends BaseMapTestClass {

    public SearchByKeyMap(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
        super(map, typeMap, handler);
    }

    public SearchByKeyMap(Map<String, Integer> map, TypeMap typeMap) {
        super(map, typeMap);
    }

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.get("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeMap.equals(HashMap)) {
            handler.sendMessage(handler.obtainMessage(SearchHM.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(SearchTM.getValue(), (int) finalTime, 0));
        }

    }
}
