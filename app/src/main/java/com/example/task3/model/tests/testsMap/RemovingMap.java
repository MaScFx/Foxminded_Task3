package com.example.task3.model.tests.testsMap;

import static com.example.task3.model.constants.MapTest.RemovingHM;
import static com.example.task3.model.constants.MapTest.RemovingTM;
import static com.example.task3.model.constants.TypeMap.HashMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class RemovingMap extends BaseMapTestClass {

    public RemovingMap(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
        super(map, typeMap, handler);
    }

    public RemovingMap(Map<String, Integer> map, TypeMap typeMap) {
        super(map, typeMap);
    }

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.remove("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeMap.equals(HashMap)) {
            handler.sendMessage(handler.obtainMessage(RemovingHM.getValue(), (int) finalTime, 0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingTM.getValue(), (int) finalTime, 0));
        }

    }
}
