package com.example.task3.model.operations.fillingCollections;

import static com.example.task3.model.constants.Operations.FillingListCompleted;

import android.os.Handler;

import com.example.task3.model.operations.IOperation;

public abstract class BaseFilling implements IOperation {

    protected final Integer size;
    protected Handler handler;

    public BaseFilling(Integer size) {
        this.size = size;
    }



    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
