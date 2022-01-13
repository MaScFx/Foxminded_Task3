package com.example.task3.fragments;


import static com.example.task3.model.constants.ListTest.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.customview.ResultView;
import com.example.task3.databinding.CollectionsFragmentBinding;
import com.example.task3.model.constants.TypeList;
import com.example.task3.model.tests.iTest;
import com.example.task3.model.tests.testsCollection.AddingBeginningList;
import com.example.task3.model.tests.testsCollection.AddingEndList;
import com.example.task3.model.tests.testsCollection.AddingMiddleList;
import com.example.task3.model.tests.testsCollection.RemovingBeginningList;
import com.example.task3.model.tests.testsCollection.RemovingEndList;
import com.example.task3.model.tests.testsCollection.RemovingMiddleList;
import com.example.task3.model.tests.testsCollection.SearchList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CollectionsFragment extends RootFragment implements ICollectionObserver {
    private CollectionsFragmentBinding binding;
    private final HashMap<Integer, ResultView> views = new HashMap<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CollectionsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewsInit();
        clearUIData();

        binding.cfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.cfEtCollectionSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) >= 9) {
                iDataKeeper.fillingList(Integer.parseInt(size), this);
                binding.cfConstraintLayout.setVisibility(View.VISIBLE);
                binding.cfFrameLayout.setVisibility(View.GONE);
                binding.cfTvSizeDesc.setVisibility(View.GONE);
                clearUIData();
            }
        });

        binding.cfBtnClear.setOnClickListener(v -> {
            binding.cfTvSizeDesc.setVisibility(View.VISIBLE);
            binding.cfFrameLayout.setVisibility(View.VISIBLE);
            binding.cfConstraintLayout.setVisibility(View.GONE);
        });
    }

    private void clearUIData() {
        for (ResultView view : views.values()) {
            view.setResult(getString(R.string.space));
        }
    }

    @Override
    public void collectionIsCompleted() {
        List<iTest> tests = new ArrayList<>();
        tests.add(new AddingBeginningList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new AddingBeginningList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new AddingBeginningList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        tests.add(new AddingMiddleList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new AddingMiddleList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new AddingMiddleList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        tests.add(new AddingEndList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new AddingEndList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new AddingEndList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        tests.add(new SearchList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new SearchList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new SearchList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        tests.add(new RemovingBeginningList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new RemovingBeginningList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new RemovingBeginningList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        tests.add(new RemovingMiddleList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new RemovingMiddleList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new RemovingMiddleList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        tests.add(new RemovingEndList(HeadlessTestsFragment.arrayList, TypeList.ArrayList));
        tests.add(new RemovingEndList(HeadlessTestsFragment.linkedList, TypeList.LinkedList));
        tests.add(new RemovingEndList(HeadlessTestsFragment.arrayList, TypeList.CopyOnWrite));

        iDataKeeper.runTests(tests);
    }

    @Override
    public void dataSetChanged(Integer testID, String result) {
        views.get(testID).setResult(result);
    }

    private void viewsInit() {
        views.put(AddingBeginningAL.getValue(), binding.cfRvAddBeginArraylist);
        views.put(AddingBeginningLL.getValue(), binding.cfRvAddBeginLinkedList);
        views.put(AddingBeginningCoW.getValue(), binding.cfRvAddBeginCopyOnWrite);
        views.put(AddingMiddleAL.getValue(), binding.cfRvAddMiddleArraylist);
        views.put(AddingMiddleLL.getValue(), binding.cfRvAddMiddleLinkedList);
        views.put(AddingMiddleCoW.getValue(), binding.cfRvAddMiddleCopyOnWrite);
        views.put(AddingEndAL.getValue(), binding.cfRvAddEndArraylist);
        views.put(AddingEndLL.getValue(), binding.cfRvAddEndLinkedList);
        views.put(AddingEndCoW.getValue(), binding.cfRvAddEndCopyOnWrite);
        views.put(SearchAL.getValue(), binding.cfRvSearchArraylist);
        views.put(SearchLL.getValue(), binding.cfRvSearchLinkedList);
        views.put(SearchCoW.getValue(), binding.cfRvSearchCopyOnWrite);
        views.put(RemovingBeginningAL.getValue(), binding.cfRvRemovingBeginningArraylist);
        views.put(RemovingBeginningLL.getValue(), binding.cfRvRemovingBeginningLinkedList);
        views.put(RemovingBeginningCoW.getValue(), binding.cfRvRemovingBeginningCopyOnWrite);
        views.put(RemovingMiddleAL.getValue(), binding.cfRvRemovingMiddleArraylist);
        views.put(RemovingMiddleLL.getValue(), binding.cfRvRemovingMiddleLinkedList);
        views.put(RemovingMiddleCoW.getValue(), binding.cfRvRemovingMiddleCopyOnWrite);
        views.put(RemovingEndAL.getValue(), binding.cfRvRemovingEndArraylist);
        views.put(RemovingEndLL.getValue(), binding.cfRvRemovingEndLinkedList);
        views.put(RemovingEndCoW.getValue(), binding.cfRvRemovingEndCopyOnWrite);
    }
}