package com.example.task3.model.fillingCollections;

import static com.example.task3.model.constants.FillingCollections.FillingListCompleted;

import android.os.Handler;

import com.example.task3.model.constants.TypeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class FillingList implements Runnable {
    private final Integer size;
    private final Handler handler;

    public FillingList(Integer size, Handler handler) {
        this.size = size;
        this.handler = handler;
    }

    @Override
    public void run() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        CopyOnWriteArrayList<Integer> copyOnWrite = new CopyOnWriteArrayList<>(arrayList);

        Map<TypeList, List<Integer>> result = new HashMap<>();
        result.put(TypeList.ArrayList, arrayList);
        result.put(TypeList.LinkedList, linkedList);
        result.put(TypeList.CopyOnWrite, copyOnWrite);

        handler.sendMessage(handler.obtainMessage(FillingListCompleted.getValue(), result));
    }
}
