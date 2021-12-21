package com.example.task3.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task3.R;
import com.example.task3.databinding.MapsFragmentBinding;

import java.util.Objects;

public class MapsFragment extends Fragment {
    private MapsFragmentBinding binding;
    private HeadlessMapFragment headlessMapFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MapsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initHeadlessFragment();

        binding.mfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.mfEtMapSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) > 0) {
                binding.mfConstraintLayout.setVisibility(View.VISIBLE);
                binding.mfFrameLayout.setVisibility(View.GONE);
                binding.mfMapSizeDesc.setVisibility(View.GONE);

                headlessMapFragment.runTasks(Integer.parseInt(binding.mfEtMapSize.getText().toString()));
            }
        });

        binding.mfBtnClear.setOnClickListener(v -> {
            binding.mfConstraintLayout.setVisibility(View.GONE);
            binding.mfFrameLayout.setVisibility(View.VISIBLE);
            binding.mfMapSizeDesc.setVisibility(View.VISIBLE);
        });

        headlessMapFragment.getAddingNewHashMap().observe(getViewLifecycleOwner(), s ->
                binding.mfRvAddingHashMap.setResult(s));

        headlessMapFragment.getAddingNewTreeMap().observe(getViewLifecycleOwner(), s ->
                binding.mfRvAddingTreeMap.setResult(s));

        headlessMapFragment.getSearchByKeyHashMap().observe(getViewLifecycleOwner(), s ->
                binding.mfRvSearchByKeyHashMap.setResult(s));

        headlessMapFragment.getSearchByKeyTreeMap().observe(getViewLifecycleOwner(), s ->
                binding.mfRvSearchByKeyTreeMap.setResult(s));

        headlessMapFragment.getRemovingHashMap().observe(getViewLifecycleOwner(), s ->
                binding.mfRvRemovingHashMap.setResult(s));

        headlessMapFragment.getRemovingTreeMap().observe(getViewLifecycleOwner(), s ->
                binding.mfRvRemovingTreeMap.setResult(s));
    }

    private void initHeadlessFragment() {
        headlessMapFragment = (HeadlessMapFragment) getFragmentManager()
                .findFragmentByTag(getString(R.string.map_fragment));

        if (headlessMapFragment == null) {
            headlessMapFragment = new HeadlessMapFragment();
            getFragmentManager().beginTransaction()
                    .add(headlessMapFragment, getString(R.string.map_fragment)).commit();
        }
    }
}