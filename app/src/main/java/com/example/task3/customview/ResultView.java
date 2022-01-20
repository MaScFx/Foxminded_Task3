package com.example.task3.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.task3.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ResultView extends FrameLayout {
    private TextInputEditText et;
    private CircularProgressIndicator cp;
    private TextInputLayout head;

    public ResultView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ResultView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ResultViewComponent);

        String cvHead = a.getString(R.styleable.ResultViewComponent_rv_head);
        setHead(cvHead);
        String cvResult = a.getString(R.styleable.ResultViewComponent_rv_result);
        setResult(cvResult);
        a.recycle();
    }

    public ResultView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);


    }

    public ResultView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.result_view, this);
        et = findViewById(R.id.rv_editText);
        cp = findViewById(R.id.rv_circularProgressIndicator);
        head = findViewById(R.id.rv_head);
    }

    public void setHead(String head) {
        this.head.setHint(head);
    }

    public void setResult(String result) {
        if (result == null || result.equals(" ")) {
            cp.setVisibility(VISIBLE);
            et.setText(" ");
        } else {
            cp.setVisibility(GONE);
            et.setText(result);
        }
    }
}
