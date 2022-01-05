package com.example.task3.model.testsMap;

import static com.example.task3.model.constants.MapTests.AddingNewHM;
import static com.example.task3.model.constants.MapTests.AddingNewTM;
import static com.example.task3.model.constants.TypeMap.HashMap;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.Map;

public class AddingNewMap implements Runnable {
    public AddingNewMap(Map<String, Integer> map, TypeMap typeMap, Handler handler) {
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
        map.put("key " + size, size);
        long finalTime = System.currentTimeMillis() - startTime;

        if (typeMap.equals(HashMap)) {
            handler.sendMessage(handler.obtainMessage(AddingNewHM.getValue(), (int) finalTime,0));
        } else {
            handler.sendMessage(handler.obtainMessage(AddingNewTM.getValue(), (int) finalTime,0));
        }

    }
}
