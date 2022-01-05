package com.example.task3.model.constants;

public enum MapTests {
    AddingNewHM(200),
    AddingNewTM(201),
    SearchHM(202),
    SearchTM(203),
    RemovingHM(204),
    RemovingTM(205);

    private final int value;

    MapTests(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
