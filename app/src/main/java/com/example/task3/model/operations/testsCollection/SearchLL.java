package com.example.task3.model.operations.testsCollection;

import static com.example.task3.model.constants.Operations.SearchLL;

import java.util.List;

public class SearchLL extends BaseListOperationClass {

    public SearchLL(List<Integer> list) {
        super(list);
    }

    @Override
    public void run() {
        int size = list.size();

        long startTime = System.currentTimeMillis();
        list.indexOf(size / 2);
        long finalTime = System.currentTimeMillis() - startTime;

        handler.sendMessage(handler.obtainMessage(SearchLL.ordinal(), (int) finalTime, 0));
    }

    @Override
    public Integer getIDOperation() {
        return SearchLL.ordinal();
    }
}
