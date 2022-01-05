package com.example.task3.model.fillingCollections;

import static com.example.task3.model.constants.FillingCollections.FillingListCompleted;
import static com.example.task3.model.constants.FillingCollections.FillingMapCompleted;

import android.os.Handler;

import com.example.task3.model.constants.TypeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FillingMap implements Runnable {
    private final Integer size;
    private final Handler handler;

    public FillingMap(Integer size, Handler handler) {
        this.size = size;
        this.handler = handler;
    }

    @Override
    public void run() {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            hashMap.put("key " + i, i);
            treeMap.put("key " + i, i);
        }

        Map<TypeMap, Map<String, Integer>> result = new HashMap<>();
        result.put(TypeMap.HashMap, hashMap);
        result.put(TypeMap.TreeMap, treeMap);
        handler.sendMessage(handler.obtainMessage(FillingMapCompleted.getValue(), result));
    }
}
