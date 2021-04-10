package com.xxx.viewmodelsample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModelProvider;

import com.xxx.viewmodelsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ObservableList<String> firstList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setViewModel(new ViewModelProvider(this).get(MainActivityViewModel.class));
        binding.setFirstList(firstList = new ObservableArrayList<>());
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());
    }
}
