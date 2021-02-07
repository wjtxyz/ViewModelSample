package com.xxx.viewmodelsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MainActivityViewModel extends AndroidViewModel {
    public final SavedStateHandle savedStateHandle;

    public final MutableLiveData<String> inputTextLiveData = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);
        this.savedStateHandle = savedStateHandle;
    }
}
