package com.co.amir.myapplication.ui.mainactivity2;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;

public class MainActivity2ViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public final ObservableField<String> text=new ObservableField<>();

    public ObservableField<String> getText() {
        return text;
    }

    public void btnClick() {
        Log.d("btn_click","the button was pressed");
        text.set("hello");
    }
}
