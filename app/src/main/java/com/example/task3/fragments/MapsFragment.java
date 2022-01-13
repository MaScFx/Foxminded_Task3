package com.example.task3.fragments;

import static com.example.task3.model.constants.MapTest.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.customview.ResultView;
import com.example.task3.databinding.MapsFragmentBinding;
import com.example.task3.model.constants.TypeMap;
import com.example.task3.model.tests.iTest;
import com.example.task3.model.tests.testsMap.AddingNewMap;
import com.example.task3.model.tests.testsMap.RemovingMap;
import com.example.task3.model.tests.testsMap.SearchByKeyMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MapsFragment extends RootFragment implements ICollectionObserver {
    private MapsFragmentBinding binding;
    private final HashMap<Integer, ResultView> views = new HashMap<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MapsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewsInit();
        clearUIData();

        binding.mfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.mfEtMapSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) > 9) {
                iDataKeeper.fillingMap(Integer.parseInt(size), this);
                binding.mfConstraintLayout.setVisibility(View.VISIBLE);
                binding.mfFrameLayout.setVisibility(View.GONE);
                binding.mfTvSizeDesc.setVisibility(View.GONE);
                clearUIData();
            }
        });

        binding.mfBtnClear.setOnClickListener(v -> {
            binding.mfConstraintLayout.setVisibility(View.GONE);
            binding.mfFrameLayout.setVisibility(View.VISIBLE);
            binding.mfTvSizeDesc.setVisibility(View.VISIBLE);
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
        tests.add(new AddingNewMap(HeadlessTestsFragment.hashMap, TypeMap.HashMap));
        tests.add(new AddingNewMap(HeadlessTestsFragment.treeMap, TypeMap.TreeMap));
        tests.add(new RemovingMap(HeadlessTestsFragment.hashMap, TypeMap.HashMap));
        tests.add(new RemovingMap(HeadlessTestsFragment.treeMap, TypeMap.TreeMap));
        tests.add(new SearchByKeyMap(HeadlessTestsFragment.hashMap, TypeMap.HashMap));
        tests.add(new SearchByKeyMap(HeadlessTestsFragment.treeMap, TypeMap.TreeMap));

        iDataKeeper.runTests(tests);
    }

    @Override
    public void dataSetChanged(Integer testID, String result) {
        views.get(testID).setResult(result);
    }

    private void viewsInit() {
        views.put(AddingNewHM.getValue(), binding.mfRvAddingHashMap);
        views.put(AddingNewTM.getValue(), binding.mfRvAddingTreeMap);
        views.put(SearchHM.getValue(), binding.mfRvSearchByKeyHashMap);
        views.put(SearchTM.getValue(), binding.mfRvSearchByKeyTreeMap);
        views.put(RemovingHM.getValue(), binding.mfRvRemovingHashMap);
        views.put(RemovingTM.getValue(), binding.mfRvRemovingTreeMap);
    }
}