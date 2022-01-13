package com.example.task3.model.tests.testsMap;

import static com.example.task3.model.constants.MapTest.AddingNewHM;
import static com.example.task3.model.constants.MapTest.AddingNewTM;
import static com.example.task3.model.constants.TypeMap.HashMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.HashMap;
import java.util.Map;

public class AddingNewMap extends BaseMapTestClass {

    public AddingNewMap(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
        super(map, typeMap, handler);
    }

    public AddingNewMap(Map<String, Integer> map, TypeMap typeMap) {
        super(map, typeMap);
    }

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.put("key " + size, size);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeMap.equals(HashMap)) {
            handler.sendMessage(handler.obtainMessage(AddingNewHM.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingNewTM.getValue(), (int) finalTime, 0));
        }

    }
}
