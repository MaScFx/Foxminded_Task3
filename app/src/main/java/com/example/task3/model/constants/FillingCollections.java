package com.example.task3.model.constants;

public enum FillingCollections {
    FillingListCompleted(301),
    FillingMapCompleted(302);

    private final int value;

    FillingCollections(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
