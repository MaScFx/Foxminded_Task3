package com.example.task3.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.databinding.CollectionsFragmentBinding;

import java.util.Objects;

public class CollectionsFragment extends Fragment {
    private CollectionsFragmentBinding binding;
    private HeadlessCollectionFragment headlessCollectionFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CollectionsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initHeadlessFragment();
        observLiveData();

        binding.cfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.cfEtCollectionSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) >= 10) {
                headlessCollectionFragment.runTasks(Integer.parseInt(size));
                binding.cfTv.setVisibility(View.GONE);
                binding.cfFrameLayout.setVisibility(View.GONE);
                binding.cfConstraintLayout.setVisibility(View.VISIBLE);
            }
        });

        binding.cfBtnClear.setOnClickListener(v -> {
            binding.cfTv.setVisibility(View.VISIBLE);
            binding.cfFrameLayout.setVisibility(View.VISIBLE);
            binding.cfConstraintLayout.setVisibility(View.GONE);
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private void observLiveData() {
        headlessCollectionFragment.getAddingBeginningAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddBeginArraylist.setResult(s));

        headlessCollectionFragment.getAddingBeginningLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddBeginLinkedList.setResult(s));

        headlessCollectionFragment.getAddingBeginningCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddBeginCopyOnWrite.setResult(s));

        headlessCollectionFragment.getAddingMiddleAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddMiddleArraylist.setResult(s));

        headlessCollectionFragment.getAddingMiddleLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddMiddleLinkedList.setResult(s));

        headlessCollectionFragment.getAddingMiddleCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddMiddleCopyOnWrite.setResult(s));

        headlessCollectionFragment.getAddingEndAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddEndArraylist.setResult(s));

        headlessCollectionFragment.getAddingEndLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddEndLinkedList.setResult(s));

        headlessCollectionFragment.getAddingEndCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddEndCopyOnWrite.setResult(s));

        headlessCollectionFragment.getAddingEndCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvAddEndCopyOnWrite.setResult(s));

        headlessCollectionFragment.getSearchAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvSearchArraylist.setResult(s));

        headlessCollectionFragment.getSearchLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvSearchLinkedList.setResult(s));

        headlessCollectionFragment.getSearchCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvSearchCopyOnWrite.setResult(s));

        headlessCollectionFragment.getRemovingBeginningAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingBeginningArraylist.setResult(s));

        headlessCollectionFragment.getRemovingBeginningLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingBeginningLinkedList.setResult(s));

        headlessCollectionFragment.getRemovingBeginningCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingBeginningCopyOnWrite.setResult(s));

        headlessCollectionFragment.getRemovingMiddleAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingMiddleArraylist.setResult(s));

        headlessCollectionFragment.getRemovingMiddleLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingMiddleLinkedList.setResult(s));

        headlessCollectionFragment.getRemovingMiddleCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingMiddleCopyOnWrite.setResult(s));

        headlessCollectionFragment.getRemovingEndAL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingEndArraylist.setResult(s));

        headlessCollectionFragment.getRemovingEndLL().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingEndLinkedList.setResult(s));

        headlessCollectionFragment.getRemovingEndCoW().observe(getViewLifecycleOwner(), s ->
                binding.cfRvRemovingEndCopyOnWrite.setResult(s));

    }

    private void initHeadlessFragment() {
        headlessCollectionFragment = (HeadlessCollectionFragment) getFragmentManager()
                .findFragmentByTag(getString(R.string.collection_fragment));

        if (headlessCollectionFragment == null) {
            headlessCollectionFragment = new HeadlessCollectionFragment();
            getFragmentManager().beginTransaction()
                    .add(headlessCollectionFragment, getString(R.string.collection_fragment)).commit();
        }
    }
}