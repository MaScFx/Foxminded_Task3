package com.example.task3.fragments;

import com.example.task3.model.tests.iTest;

import java.util.List;

public interface IDataKeeper {
    void fillingList(Integer size, ICollectionObserver observer);

    void fillingMap(Integer size, ICollectionObserver observer);

    void runTests(List<iTest> testsList);
}
