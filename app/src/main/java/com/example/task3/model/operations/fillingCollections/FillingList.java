package com.example.task3.model.operations.fillingCollections;

import static com.example.task3.model.constants.Operations.FillingListCompleted;

import com.example.task3.fragments.HeadlessTestsFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class FillingList extends BaseFilling {

    public FillingList(Integer size) {
        super(size);
    }

    @Override
    public void run() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        CopyOnWriteArrayList<Integer> copyOnWrite = new CopyOnWriteArrayList<>(arrayList);

        HeadlessTestsFragment.arrayList = arrayList;
        HeadlessTestsFragment.linkedList = linkedList;
        HeadlessTestsFragment.copyOnWrite = copyOnWrite;

        handler.sendMessage(handler.obtainMessage(FillingListCompleted.ordinal(), 0, 0));
    }
    @Override
    public Integer getIDOperation() {
        return FillingListCompleted.ordinal();
    }
}
