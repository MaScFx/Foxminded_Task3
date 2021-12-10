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
import com.example.task3.model.TestMap;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapsFragment extends Fragment {
    private MapsFragmentBinding binding;
    private TestMap testHashMap;
    private TestMap testTreeMap;
    private ExecutorService executor;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MapsFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        executor = Executors.newFixedThreadPool(2);
        binding.mfConstraintLayout.setVisibility(View.GONE);
        binding.mfFrameLayout.setVisibility(View.VISIBLE);
        binding.mfMapSizeDesc.setVisibility(View.VISIBLE);

        binding.mfBtnCalculate.setOnClickListener(v -> {
            String size = Objects.requireNonNull(binding.mfEtMapSize.getText()).toString();
            if (!size.equals("") && Integer.parseInt(size) > 0) {
                binding.mfConstraintLayout.setVisibility(View.VISIBLE);
                binding.mfFrameLayout.setVisibility(View.GONE);
                binding.mfMapSizeDesc.setVisibility(View.GONE);

                initTask(Integer.parseInt(binding.mfEtMapSize.getText().toString()));

                executor.execute(testHashMap);
                executor.execute(testTreeMap);
            }
        });

        binding.mfBtnClear.setOnClickListener(v -> {
            binding.mfConstraintLayout.setVisibility(View.GONE);
            binding.mfFrameLayout.setVisibility(View.VISIBLE);
            binding.mfMapSizeDesc.setVisibility(View.VISIBLE);
            clearScreen();
        });


    }


    private void initTask(Integer size) {
        testHashMap = new TestMap(new HashMap<>(), size, binding);
        testTreeMap = new TestMap(new TreeMap<>(), size, binding);
    }


    private void clearScreen() {
        binding.mfEtAddingHashMap.setText(R.string.space);
        binding.mfCpiAddingHashMap.setVisibility(View.VISIBLE);
        binding.mfEtAddingTreeMap.setText(R.string.space);
        binding.mfCpiAddingTreeMap.setVisibility(View.VISIBLE);

        binding.mfEtSearchByKeyHashMap.setText(R.string.space);
        binding.mfCpiSearchByKeyHashMap.setVisibility(View.VISIBLE);
        binding.mfEtSearchByKeyTreeMap.setText(R.string.space);
        binding.mfCpiSearchByKeyTreeMap.setVisibility(View.VISIBLE);

        binding.mfEtRemovingHashMap.setText(R.string.space);
        binding.mfCpiRemovingHashMap.setVisibility(View.VISIBLE);
        binding.mfEtRemovingTreeMap.setText(R.string.space);
        binding.mfCpiRemovingTreeMap.setVisibility(View.VISIBLE);
    }

}