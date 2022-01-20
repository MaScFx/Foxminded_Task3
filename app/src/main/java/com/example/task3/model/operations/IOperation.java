package com.example.task3.model.operations;

import android.os.Handler;

public interface IOperation extends Runnable {
    Integer getIDOperation();

    void setHandler(Handler handler);
}
