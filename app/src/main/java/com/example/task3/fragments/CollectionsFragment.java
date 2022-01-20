package com.example.task3.fragments;


import static com.example.task3.model.constants.Operations.*;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.customview.ResultView;
import com.example.task3.databinding.CollectionsFragmentBinding;
import com.example.task3.model.constants.Operations;
import com.example.task3.model.operations.IOperation;
import com.example.task3.model.operations.fillingCollections.FillingList;
import com.example.task3.model.operations.testsCollection.AddingBeginningAL;
import com.example.task3.model.operations.testsCollection.AddingBeginningCoW;
import com.example.task3.model.operations.testsCollection.AddingBeginningLL;
import com.example.task3.model.operations.testsCollection.AddingEndAL;
import com.example.task3.model.operations.testsCollection.AddingEndCoW;
import com.example.task3.model.operations.testsCollection.AddingEndLL;
import com.example.task3.model.operations.testsCollection.AddingMiddleAL;
import com.example.task3.model.operations.testsCollection.AddingMiddleCoW;
import com.example.task3.model.operations.testsCollection.AddingMiddleLL;
import com.example.task3.model.operations.testsCollection.RemovingBeginningAL;
import com.example.task3.model.operations.testsCollection.RemovingBeginningCoW;
import com.example.task3.model.operations.testsCollection.RemovingBeginningLL;
import com.example.task3.model.operations.testsCollection.RemovingEndAL;
import com.example.task3.model.operations.testsCollection.RemovingEndCoW;
import com.example.task3.model.operations.testsCollection.RemovingEndLL;
import com.example.task3.model.operations.testsCollection.RemovingMiddleAL;
import com.example.task3.model.operations.testsCollection.RemovingMiddleCoW;
import com.example.task3.model.operations.testsCollection.RemovingMiddleLL;
import com.example.task3.model.operations.testsCollection.SearchAL;
import com.example.task3.model.operations.testsCollection.SearchCoW;
import com.example.task3.model.operations.testsCollection.SearchLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CollectionsFragment extends RootFragment implements IResultObserver {
    private CollectionsFragmentBinding binding;
    private final HashMap<Integer, ResultView> views = new HashMap<>();
    private Boolean check = false;

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
        checkPreviousData();

        binding.btnCalculateList.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.etCollectionSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) >= 9) {
                List<IOperation> fillingList = new ArrayList<>();
                fillingList.add(new FillingList(Integer.parseInt(size)));
                iDataKeeper.runOperation(fillingList, this);

                binding.cfConstraintLayout.setVisibility(View.VISIBLE);
                binding.frameLayoutList.setVisibility(View.GONE);
                binding.tvSizeDescList.setVisibility(View.GONE);

                clearUIData();
            }
        });

        binding.btnClearList.setOnClickListener(v -> {
            binding.tvSizeDescList.setVisibility(View.VISIBLE);
            binding.frameLayoutList.setVisibility(View.VISIBLE);
            binding.cfConstraintLayout.setVisibility(View.GONE);
        });
    }

    private void checkPreviousData() {
        HashMap<Integer, String> data = iDataKeeper.getResults();
        String currentData;
        for (Integer i : views.keySet()) {
            currentData = data.get(i);
            if (currentData != null && !Objects.equals(currentData, getString(R.string.space))) {
                if (!check) {
                    binding.cfConstraintLayout.setVisibility(View.VISIBLE);
                    binding.frameLayoutList.setVisibility(View.GONE);
                    binding.tvSizeDescList.setVisibility(View.GONE);
                    check = true;
                }
                ResultView resultView = views.get(i);
                resultView.setResult(currentData);
            }
        }
    }


    private void clearUIData() {
        for (ResultView view : views.values()) {
            view.setResult(getString(R.string.space));
        }
    }

    public void createTests() {
        List<IOperation> tests = new ArrayList<>();
        tests.add(new AddingBeginningAL(HeadlessTestsFragment.arrayList));
        tests.add(new AddingBeginningLL(HeadlessTestsFragment.linkedList));
        tests.add(new AddingBeginningCoW(HeadlessTestsFragment.arrayList));

        tests.add(new AddingMiddleAL(HeadlessTestsFragment.arrayList));
        tests.add(new AddingMiddleLL(HeadlessTestsFragment.linkedList));
        tests.add(new AddingMiddleCoW(HeadlessTestsFragment.arrayList));

        tests.add(new AddingEndAL(HeadlessTestsFragment.arrayList));
        tests.add(new AddingEndLL(HeadlessTestsFragment.linkedList));
        tests.add(new AddingEndCoW(HeadlessTestsFragment.arrayList));

        tests.add(new SearchAL(HeadlessTestsFragment.arrayList));
        tests.add(new SearchLL(HeadlessTestsFragment.linkedList));
        tests.add(new SearchCoW(HeadlessTestsFragment.arrayList));

        tests.add(new RemovingBeginningAL(HeadlessTestsFragment.arrayList));
        tests.add(new RemovingBeginningLL(HeadlessTestsFragment.linkedList));
        tests.add(new RemovingBeginningCoW(HeadlessTestsFragment.arrayList));

        tests.add(new RemovingMiddleAL(HeadlessTestsFragment.arrayList));
        tests.add(new RemovingMiddleLL(HeadlessTestsFragment.linkedList));
        tests.add(new RemovingMiddleCoW(HeadlessTestsFragment.arrayList));

        tests.add(new RemovingEndAL(HeadlessTestsFragment.arrayList));
        tests.add(new RemovingEndLL(HeadlessTestsFragment.linkedList));
        tests.add(new RemovingEndCoW(HeadlessTestsFragment.arrayList));

        iDataKeeper.runOperation(tests, this);
    }

    @Override
    public void dataSetChanged(Integer testID, String result) {
        if (testID == Operations.FillingListCompleted.ordinal()) {
            createTests();
        } else {
            views.get(testID).setResult(result);
        }
    }

    private void viewsInit() {
        views.put(AddingBeginningAL.ordinal(), binding.rvAddBeginArraylist);
        views.put(AddingBeginningLL.ordinal(), binding.rvAddBeginLinkedList);
        views.put(AddingBeginningCoW.ordinal(), binding.rvAddBeginCopyOnWrite);
        views.put(AddingMiddleAL.ordinal(), binding.rvAddMiddleArraylist);
        views.put(AddingMiddleLL.ordinal(), binding.rvAddMiddleLinkedList);
        views.put(AddingMiddleCoW.ordinal(), binding.rvAddMiddleCopyOnWrite);
        views.put(AddingEndAL.ordinal(), binding.rvAddEndArraylist);
        views.put(AddingEndLL.ordinal(), binding.rvAddEndLinkedList);
        views.put(AddingEndCoW.ordinal(), binding.rvAddEndCopyOnWrite);
        views.put(SearchAL.ordinal(), binding.rvSearchArraylist);
        views.put(SearchLL.ordinal(), binding.rvSearchLinkedList);
        views.put(SearchCoW.ordinal(), binding.rvSearchCopyOnWrite);
        views.put(RemovingBeginningAL.ordinal(), binding.rvRemovingBeginningArraylist);
        views.put(RemovingBeginningLL.ordinal(), binding.rvRemovingBeginningLinkedList);
        views.put(RemovingBeginningCoW.ordinal(), binding.rvRemovingBeginningCopyOnWrite);
        views.put(RemovingMiddleAL.ordinal(), binding.rvRemovingMiddleArraylist);
        views.put(RemovingMiddleLL.ordinal(), binding.rvRemovingMiddleLinkedList);
        views.put(RemovingMiddleCoW.ordinal(), binding.rvRemovingMiddleCopyOnWrite);
        views.put(RemovingEndAL.ordinal(), binding.rvRemovingEndArraylist);
        views.put(RemovingEndLL.ordinal(), binding.rvRemovingEndLinkedList);
        views.put(RemovingEndCoW.ordinal(), binding.rvRemovingEndCopyOnWrite);
    }
}