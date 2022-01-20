package com.example.task3.model.operations.fillingCollections;

import static com.example.task3.model.constants.Operations.FillingMapCompleted;

import com.example.task3.fragments.HeadlessTestsFragment;


import java.util.HashMap;
import java.util.TreeMap;

public class FillingMap extends BaseFilling {

    public FillingMap(Integer size) {
        super(size);
    }

    @Override
    public void run() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            hashMap.put("key " + i, i);
            treeMap.put("key " + i, i);
        }

        HeadlessTestsFragment.hashMap = hashMap;
        HeadlessTestsFragment.treeMap = treeMap;

        handler.sendMessage(handler.obtainMessage(FillingMapCompleted.ordinal(), 0, 0));
    }
    @Override
    public Integer getIDOperation() {
        return FillingMapCompleted.ordinal();
    }
}
