package com.example.task3.model;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.task3.databinding.MapsFragmentBinding;

import java.util.HashMap;
import java.util.Map;

public class TestMap implements Runnable {
    private final Map<String, Integer> map;
    private final Integer count;
    private final MapsFragmentBinding binding;
    private Handler handler;

    public TestMap(Map<String, Integer> map, Integer count, MapsFragmentBinding binding) {
        this.map = map;
        this.count = count < 1 ? 1 : count;
        this.binding = binding;
    }

    @Override
    public void run() {
        handler = new Handler(Looper.getMainLooper());
        for (int i = 0; i < count; i++) {
            map.put("key " + i, i);
        }
        addingNew();
        searchByKey();
        removing();
    }

    private void addingNew() {
        long startTime = System.currentTimeMillis();
        map.put("key " + count, count);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends Map> mapClass = map.getClass();
        handler.post(() -> {
            if (HashMap.class.equals(mapClass)) {
                binding.mfEtAddingHashMap.setText(String.valueOf(finalTime));
                binding.mfCpiAddingHashMap.setVisibility(View.GONE);
            } else {
                binding.mfEtAddingTreeMap.setText(String.valueOf(finalTime));
                binding.mfCpiAddingTreeMap.setVisibility(View.GONE);
            }
        });
    }

    private void searchByKey() {
        long startTime = System.currentTimeMillis();
        map.get("key " + count);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends Map> mapClass = map.getClass();
        handler.post(() -> {
            if (HashMap.class.equals(mapClass)) {
                binding.mfEtSearchByKeyHashMap.setText(String.valueOf(finalTime));
                binding.mfCpiSearchByKeyHashMap.setVisibility(View.GONE);
            } else {
                binding.mfEtSearchByKeyTreeMap.setText(String.valueOf(finalTime));
                binding.mfCpiSearchByKeyTreeMap.setVisibility(View.GONE);
            }
        });

    }

    private void removing() {
        long startTime = System.currentTimeMillis();
        map.remove("key " + count);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends Map> mapclass = map.getClass();
        handler.post(() -> {
            if (HashMap.class.equals(mapclass)) {
                binding.mfEtRemovingHashMap.setText(String.valueOf(finalTime));
                binding.mfCpiRemovingHashMap.setVisibility(View.GONE);
            } else {
                binding.mfEtRemovingTreeMap.setText(String.valueOf(finalTime));
                binding.mfCpiRemovingTreeMap.setVisibility(View.GONE);
            }
        });
    }


}
