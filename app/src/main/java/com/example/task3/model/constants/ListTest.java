package com.example.task3.model.constants;

public enum ListTest {
    AddingBeginningAL(100),
    AddingBeginningLL(101),
    AddingBeginningCoW(102),
    AddingMiddleAL(103),
    AddingMiddleLL(104),
    AddingMiddleCoW(105),
    AddingEndAL(106),
    AddingEndLL(107),
    AddingEndCoW(108),
    SearchAL(109),
    SearchLL(110),
    SearchCoW(111),
    RemovingBeginningAL(112),
    RemovingBeginningLL(113),
    RemovingBeginningCoW(114),
    RemovingMiddleAL(115),
    RemovingMiddleLL(116),
    RemovingMiddleCoW(117),
    RemovingEndAL(118),
    RemovingEndLL(119),
    RemovingEndCoW(120);


    private final int value;

    ListTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}