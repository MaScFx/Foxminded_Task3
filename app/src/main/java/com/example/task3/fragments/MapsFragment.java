package com.example.task3.fragments;

import static com.example.task3.model.constants.MapTests.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.databinding.MapsFragmentBinding;
import com.example.task3.model.constants.MapTests;

import java.util.HashMap;
import java.util.Objects;

public class MapsFragment extends RootFragment implements NotifyDataSetChanged {
    private MapsFragmentBinding binding;
    private HashMap<MapTests, String> results;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MapsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headlessTestsFragment.setMapDataObserver(this);
        results = headlessTestsFragment.getMapResults();
        refreshUIData();

        binding.mfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.mfEtMapSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) > 9) {
                headlessTestsFragment.runMapTests(Integer.parseInt(size));
                binding.mfConstraintLayout.setVisibility(View.VISIBLE);
                binding.mfFrameLayout.setVisibility(View.GONE);
                binding.mfTvSizeDesc.setVisibility(View.GONE);
                refreshUIData();
            }
        });

        binding.mfBtnClear.setOnClickListener(v -> {
            binding.mfConstraintLayout.setVisibility(View.GONE);
            binding.mfFrameLayout.setVisibility(View.VISIBLE);
            binding.mfTvSizeDesc.setVisibility(View.VISIBLE);
        });

    }

    private void refreshUIData() {
        binding.mfRvAddingHashMap.setResult(results.get(AddingNewHM));
        binding.mfRvAddingTreeMap.setResult(results.get(AddingNewTM));
        binding.mfRvSearchByKeyHashMap.setResult(results.get(SearchHM));
        binding.mfRvSearchByKeyTreeMap.setResult(results.get(SearchTM));
        binding.mfRvRemovingHashMap.setResult(results.get(RemovingHM));
        binding.mfRvRemovingTreeMap.setResult(results.get(RemovingTM));
    }

    @Override
    public void notifyDataSetChanged() {
        refreshUIData();
    }
}