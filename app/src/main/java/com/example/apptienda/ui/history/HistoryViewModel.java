package com.example.apptienda.ui.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HistoryViewModel() {
        mText = new MutableLiveData<>();
       // mText.setValue("Historial de Compras");
    }

    public LiveData<String> getText() {
        return mText;
    }
}