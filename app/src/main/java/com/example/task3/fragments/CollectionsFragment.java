package com.example.task3.fragments;


import static com.example.task3.model.constants.ListTests.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.databinding.CollectionsFragmentBinding;
import com.example.task3.model.constants.ListTests;

import java.util.HashMap;
import java.util.Objects;

public class CollectionsFragment extends RootFragment implements NotifyDataSetChanged {
    private CollectionsFragmentBinding binding;
    private HashMap<ListTests, String> results;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CollectionsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headlessTestsFragment.setListDataObserver(this);
        results = headlessTestsFragment.getListResults();
        refreshUIData();

        binding.cfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.cfEtCollectionSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) >= 9) {
                headlessTestsFragment.runListTests(Integer.parseInt(size));
                binding.cfConstraintLayout.setVisibility(View.VISIBLE);
                binding.cfFrameLayout.setVisibility(View.GONE);
                binding.cfTvSizeDesc.setVisibility(View.GONE);
                refreshUIData();
            }
        });

        binding.cfBtnClear.setOnClickListener(v -> {
            binding.cfTvSizeDesc.setVisibility(View.VISIBLE);
            binding.cfFrameLayout.setVisibility(View.VISIBLE);
            binding.cfConstraintLayout.setVisibility(View.GONE);
        });
    }

    private void refreshUIData() {
        binding.cfRvAddBeginArraylist.setResult(results.get(AddingBeginningAL));
        binding.cfRvAddBeginLinkedList.setResult(results.get(AddingBeginningLL));
        binding.cfRvAddBeginCopyOnWrite.setResult(results.get(AddingBeginningCoW));

        binding.cfRvAddMiddleArraylist.setResult(results.get(AddingMiddleAL));
        binding.cfRvAddMiddleLinkedList.setResult(results.get(AddingMiddleLL));
        binding.cfRvAddMiddleCopyOnWrite.setResult(results.get(AddingMiddleCoW));

        binding.cfRvAddEndArraylist.setResult(results.get(AddingEndAL));
        binding.cfRvAddEndLinkedList.setResult(results.get(AddingEndLL));
        binding.cfRvAddEndCopyOnWrite.setResult(results.get(AddingEndCoW));

        binding.cfRvSearchArraylist.setResult(results.get(SearchAL));
        binding.cfRvSearchLinkedList.setResult(results.get(SearchLL));
        binding.cfRvSearchCopyOnWrite.setResult(results.get(SearchCoW));

        binding.cfRvRemovingBeginningArraylist.setResult(results.get(RemovingBeginningAL));
        binding.cfRvRemovingBeginningLinkedList.setResult(results.get(RemovingBeginningLL));
        binding.cfRvRemovingBeginningCopyOnWrite.setResult(results.get(RemovingBeginningCoW));

        binding.cfRvRemovingMiddleArraylist.setResult(results.get(RemovingMiddleAL));
        binding.cfRvRemovingMiddleLinkedList.setResult(results.get(RemovingMiddleLL));
        binding.cfRvRemovingMiddleCopyOnWrite.setResult(results.get(RemovingMiddleCoW));

        binding.cfRvRemovingEndArraylist.setResult(results.get(RemovingEndAL));
        binding.cfRvRemovingEndLinkedList.setResult(results.get(RemovingEndLL));
        binding.cfRvRemovingEndCopyOnWrite.setResult(results.get(RemovingEndCoW));
    }

    @Override
    public void notifyDataSetChanged() {
        refreshUIData();
    }
}