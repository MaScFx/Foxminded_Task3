package com.example.task3.fragments;

public interface ICollectionObserver {
    void collectionIsCompleted();

    void dataSetChanged(Integer testID, String result);
}
