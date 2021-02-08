package com.xxx.viewmodelsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private static final String TAG = "MainActivityViewModel";
    public final SavedStateHandle savedStateHandle;

    public final MutableLiveData<String> inputTextLiveData = new MutableLiveData<>();

    public final List<String> secondList = new ObservableArrayList<>();

    public MainActivityViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);
        this.savedStateHandle = savedStateHandle;
    }

    public void onAddItem(List<String>... lists) {
        final String sDate = String.valueOf(new Date());
        Arrays.stream(lists).forEach(s -> s.add(sDate));
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public MutableLiveData getLiveDataObservableListSavedState(@NonNull String name) {
        final MutableLiveData liveData = savedStateHandle.getLiveData(name);
        if (!(liveData.getValue() instanceof ObservableList)) {
            liveData.setValue(new ObservableArrayList() {
                {
                    if (liveData.getValue() != null) {
                        addAll((Collection) liveData.getValue());
                    }
                }
            });
        }
        return liveData;
    }
}
