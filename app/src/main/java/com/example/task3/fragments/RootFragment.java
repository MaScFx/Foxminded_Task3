package com.example.task3.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task3.R;

public abstract class RootFragment extends Fragment {
    protected HeadlessTestsFragment headlessTestsFragment;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initHeadlessFragment();
    }

    private void initHeadlessFragment() {
        headlessTestsFragment = (HeadlessTestsFragment) getFragmentManager()
                .findFragmentByTag(getString(R.string.collection_fragment));

        if (headlessTestsFragment == null) {
            headlessTestsFragment = new HeadlessTestsFragment();
            getFragmentManager().beginTransaction()
                    .add(headlessTestsFragment, getString(R.string.collection_fragment)).commit();
        }
    }
}
