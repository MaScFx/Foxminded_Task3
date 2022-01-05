package com.example.task3.model.testsMap;

import static com.example.task3.model.constants.MapTests.RemovingHM;
import static com.example.task3.model.constants.MapTests.RemovingTM;
import static com.example.task3.model.constants.TypeMap.HashMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class RemovingMap implements Runnable {
    public RemovingMap(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
        this.handler = handler;
        this.map = map;
        this.typeMap = typeMap;
    }

    private final Map<String, Integer> map;
    private final TypeMap typeMap;
    private final Handler handler;

    @Override
    public void run() {
        int size = map.size();
        long startTime = System.currentTimeMillis();
        map.remove("key " + size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeMap.equals(HashMap)) {
            handler.sendMessage(handler.obtainMessage(RemovingHM.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(RemovingTM.getValue(), (int) finalTime,0));
        }

    }
}
