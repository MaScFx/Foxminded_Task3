package com.example.task3.model;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.task3.databinding.CollectionsFragmentBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestsList implements Runnable {
    private List<Integer> list;
    private final Integer count;
    private final CollectionsFragmentBinding binding;
    private Handler handler;

    public TestsList(List<Integer> list, Integer count, CollectionsFragmentBinding binding) {
        this.list = list;
        this.count = count < 1 ? 1 : count;
        this.binding = binding;
    }

    @Override
    public void run() {
        handler = new Handler(Looper.getMainLooper());
        if (list.getClass().equals(CopyOnWriteArrayList.class)) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                arrayList.add(i);
            }
            list = new CopyOnWriteArrayList<>(arrayList);
        } else {
            for (int i = 0; i < count; i++) {
                list.add(i);
            }
        }
        addingInTheBeginning();
        addingInTheMiddle();
        addingInTheEnd();
        searchByValue();
        removingInTheBeginning();
        removingInTheMiddle();
        removingInTheEnd();
    }


    private void addingInTheBeginning() {
        long startTime = System.currentTimeMillis();
        list.add(0, 1);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtAddBeginArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiAddBeginArraylist.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtAddBeginLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiAddBeginLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtAddBeginCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiAddBeginCopyOnWrite.setVisibility(View.GONE);
            }
        });
    }

    private void addingInTheMiddle() {
        long startTime = System.currentTimeMillis();
        list.add(list.size() / 2, 1);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtAddMiddleArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiAddMiddleArrayList.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtAddMiddleLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiAddMiddleLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtAddMiddleCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiAddMiddleCopyOnWrite.setVisibility(View.GONE);
            }
        });
    }

    private void addingInTheEnd() {
        long startTime = System.currentTimeMillis();
        list.add(1);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtAddEndArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiAddEndArraylist.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtAddEndLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiAddEndLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtAddEndCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiAddEndCopyOnWriteList.setVisibility(View.GONE);
            }
        });
    }

    private void searchByValue() {
        long startTime = System.currentTimeMillis();
        list.indexOf(list.size());
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtSearchArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiSearchArrayList.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtSearchLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiSearchLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtSearchCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiSearchCopyOnWrite.setVisibility(View.GONE);
            }
        });
    }

    private void removingInTheBeginning() {
        long startTime = System.currentTimeMillis();
        list.remove(0);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtRemovingBeginningArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingBeginningArraylist.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtRemovingBeginningLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingBeginningLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtRemovingBeginningCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingBeginningCopyOnWrite.setVisibility(View.GONE);
            }
        });

    }

    private void removingInTheMiddle() {
        long startTime = System.currentTimeMillis();
        list.remove(list.size() / 2);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtRemovingMiddleArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingMiddleArrayList.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtRemovingMiddleLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingMiddleLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtRemovingMiddleCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingMiddleCopyOnWrite.setVisibility(View.GONE);
            }
        });

    }

    private void removingInTheEnd() {
        long startTime = System.currentTimeMillis();
        list.remove(list.size() - 1);
        long finalTime = System.currentTimeMillis() - startTime;
        Class<? extends List> aClass = list.getClass();
        handler.post(() -> {
            if (ArrayList.class.equals(aClass)) {
                binding.cfEtRemovingEndArraylist.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingEndArraylist.setVisibility(View.GONE);
            } else if (LinkedList.class.equals(aClass)) {
                binding.cfEtRemovingEndLinkedList.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingEndLinkedList.setVisibility(View.GONE);
            } else {
                binding.cfEtRemovingEndCopyOnWrite.setText(String.valueOf(finalTime));
                binding.cfCpiRemovingEndCopyOnWrite.setVisibility(View.GONE);
            }
        });

    }


}

