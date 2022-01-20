package com.example.task3.fragments;

import static com.example.task3.model.constants.Operations.AddingNewHM;
import static com.example.task3.model.constants.Operations.AddingNewTM;
import static com.example.task3.model.constants.Operations.RemovingHM;
import static com.example.task3.model.constants.Operations.RemovingTM;
import static com.example.task3.model.constants.Operations.SearchHM;
import static com.example.task3.model.constants.Operations.SearchTM;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.customview.ResultView;
import com.example.task3.databinding.MapsFragmentBinding;
import com.example.task3.model.constants.Operations;
import com.example.task3.model.operations.IOperation;
import com.example.task3.model.operations.fillingCollections.FillingMap;
import com.example.task3.model.operations.testsMap.AddingNewHashMap;
import com.example.task3.model.operations.testsMap.AddingNewTreeMap;
import com.example.task3.model.operations.testsMap.RemovingHashMap;
import com.example.task3.model.operations.testsMap.RemovingTreeMap;
import com.example.task3.model.operations.testsMap.SearchByKeyHashMap;
import com.example.task3.model.operations.testsMap.SearchByKeyTreeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MapsFragment extends RootFragment implements IResultObserver {
    private MapsFragmentBinding binding;
    private final HashMap<Integer, ResultView> views = new HashMap<>();
    private Boolean check = false;

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
        checkPreviousData();

        binding.btnCalculateMap.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.etMapSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) > 9) {

                List<IOperation> fillingMap = new ArrayList<>();
                fillingMap.add(new FillingMap(Integer.parseInt(size)));
                iDataKeeper.runOperation(fillingMap, this);

                binding.constraintLayout.setVisibility(View.VISIBLE);
                binding.frameLayoutMap.setVisibility(View.GONE);
                binding.tvSizeDescMap.setVisibility(View.GONE);
                clearUIData();
            }
        });

        binding.btnClearMap.setOnClickListener(v -> {
            binding.constraintLayout.setVisibility(View.GONE);
            binding.frameLayoutMap.setVisibility(View.VISIBLE);
            binding.tvSizeDescMap.setVisibility(View.VISIBLE);
        });
    }

    private void clearUIData() {
        for (ResultView view : views.values()) {
            view.setResult(getString(R.string.space));
        }
    }

    private void checkPreviousData() {
        HashMap<Integer, String> data = iDataKeeper.getResults();
        String currentData;
        for (Integer i : views.keySet()) {
            currentData = data.get(i);
            if (currentData != null && !Objects.equals(currentData, getString(R.string.space))) {
                if (!check) {
                    binding.constraintLayout.setVisibility(View.VISIBLE);
                    binding.frameLayoutMap.setVisibility(View.GONE);
                    binding.tvSizeDescMap.setVisibility(View.GONE);
                    check = true;
                }
                ResultView resultView = views.get(i);
                resultView.setResult(currentData);
            }
        }
    }

    public void createTests() {
        List<IOperation> tests = new ArrayList<>();
        tests.add(new AddingNewHashMap(HeadlessTestsFragment.hashMap));
        tests.add(new AddingNewTreeMap(HeadlessTestsFragment.treeMap));
        tests.add(new RemovingHashMap(HeadlessTestsFragment.hashMap));
        tests.add(new RemovingTreeMap(HeadlessTestsFragment.treeMap));
        tests.add(new SearchByKeyHashMap(HeadlessTestsFragment.hashMap));
        tests.add(new SearchByKeyTreeMap(HeadlessTestsFragment.treeMap));

        iDataKeeper.runOperation(tests, this);
    }

    @Override
    public void dataSetChanged(Integer testID, String result) {
        if (testID == Operations.FillingMapCompleted.ordinal()) {
            createTests();
        } else {
            views.get(testID).setResult(result);
        }
    }

    private void viewsInit() {
        views.put(AddingNewHM.ordinal(), binding.rvAddingHashMap);
        views.put(AddingNewTM.ordinal(), binding.rvAddingTreeMap);
        views.put(SearchHM.ordinal(), binding.rvSearchByKeyHashMap);
        views.put(SearchTM.ordinal(), binding.rvSearchByKeyTreeMap);
        views.put(RemovingHM.ordinal(), binding.rvRemovingHashMap);
        views.put(RemovingTM.ordinal(), binding.rvRemovingTreeMap);
    }
}