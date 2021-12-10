package com.example.task3.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.databinding.CollectionsFragmentBinding;
import com.example.task3.model.TestsList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionsFragment extends Fragment {
    private CollectionsFragmentBinding binding;
    private TestsList testsArrayList;
    private TestsList testsLinkedList;
    private TestsList testsCopyOnWriteList;
    private ExecutorService executor;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CollectionsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        executor = Executors.newFixedThreadPool(3);
        binding.cfConstraintLayout.setVisibility(View.GONE);

        binding.cfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.cfEtCollectionSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) > 0) {
                binding.cfTv.setVisibility(View.GONE);
                binding.cfFrameLayout.setVisibility(View.GONE);
                binding.cfConstraintLayout.setVisibility(View.VISIBLE);

                initTasks(Integer.parseInt(binding.cfEtCollectionSize.getText().toString()));

                executor.execute(testsArrayList);
                executor.execute(testsLinkedList);
                executor.execute(testsCopyOnWriteList);
            }
        });

        binding.cfBtnClear.setOnClickListener(v -> {
            binding.cfTv.setVisibility(View.VISIBLE);
            binding.cfFrameLayout.setVisibility(View.VISIBLE);
            binding.cfConstraintLayout.setVisibility(View.GONE);
            clearScreen();
        });
    }

    private void initTasks(Integer size) {
        testsArrayList = new TestsList(new ArrayList<>(), size, binding);
        testsLinkedList = new TestsList(new LinkedList<>(), size, binding);
        testsCopyOnWriteList = new TestsList(new CopyOnWriteArrayList<>(), size, binding);
    }

    private void clearScreen() {
        binding.cfEtAddBeginArraylist.setText(R.string.space);
        binding.cfEtAddBeginLinkedList.setText(R.string.space);
        binding.cfEtAddBeginCopyOnWrite.setText(R.string.space);

        binding.cfEtAddMiddleArraylist.setText(R.string.space);
        binding.cfEtAddMiddleLinkedList.setText(R.string.space);
        binding.cfEtAddMiddleCopyOnWrite.setText(R.string.space);

        binding.cfEtAddEndArraylist.setText(R.string.space);
        binding.cfEtAddEndLinkedList.setText(R.string.space);
        binding.cfEtAddEndCopyOnWrite.setText(R.string.space);

        binding.cfEtSearchArraylist.setText(R.string.space);
        binding.cfEtSearchLinkedList.setText(R.string.space);
        binding.cfEtSearchCopyOnWrite.setText(R.string.space);

        binding.cfEtRemovingBeginningArraylist.setText(R.string.space);
        binding.cfEtRemovingBeginningLinkedList.setText(R.string.space);
        binding.cfEtRemovingBeginningCopyOnWrite.setText(R.string.space);

        binding.cfEtRemovingMiddleArraylist.setText(R.string.space);
        binding.cfEtRemovingMiddleLinkedList.setText(R.string.space);
        binding.cfEtRemovingMiddleCopyOnWrite.setText(R.string.space);

        binding.cfEtRemovingEndArraylist.setText(R.string.space);
        binding.cfEtRemovingEndLinkedList.setText(R.string.space);
        binding.cfEtRemovingEndCopyOnWrite.setText(R.string.space);

        binding.cfCpiAddBeginArraylist.setVisibility(View.VISIBLE);
        binding.cfCpiAddBeginLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiAddBeginCopyOnWrite.setVisibility(View.VISIBLE);

        binding.cfCpiAddMiddleArrayList.setVisibility(View.VISIBLE);
        binding.cfCpiAddMiddleLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiAddMiddleCopyOnWrite.setVisibility(View.VISIBLE);

        binding.cfCpiAddEndArraylist.setVisibility(View.VISIBLE);
        binding.cfCpiAddEndLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiAddEndCopyOnWriteList.setVisibility(View.VISIBLE);

        binding.cfCpiSearchArrayList.setVisibility(View.VISIBLE);
        binding.cfCpiSearchLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiSearchCopyOnWrite.setVisibility(View.VISIBLE);

        binding.cfCpiRemovingBeginningArraylist.setVisibility(View.VISIBLE);
        binding.cfCpiRemovingBeginningLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiRemovingBeginningCopyOnWrite.setVisibility(View.VISIBLE);

        binding.cfCpiRemovingMiddleArrayList.setVisibility(View.VISIBLE);
        binding.cfCpiRemovingMiddleLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiRemovingMiddleCopyOnWrite.setVisibility(View.VISIBLE);

        binding.cfCpiRemovingEndArraylist.setVisibility(View.VISIBLE);
        binding.cfCpiRemovingEndLinkedList.setVisibility(View.VISIBLE);
        binding.cfCpiRemovingEndCopyOnWrite.setVisibility(View.VISIBLE);
    }


}