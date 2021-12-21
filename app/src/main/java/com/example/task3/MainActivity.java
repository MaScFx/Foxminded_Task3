package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.task3.adapter.PagerAdapter;
import com.example.task3.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.mainVp2.setAdapter(new PagerAdapter(this));
        new TabLayoutMediator(binding.tabLayout, binding.mainVp2, ((tab, position) ->
                tab.setText(position == 0 ? R.string.collections : R.string.maps))).attach();

    }
}