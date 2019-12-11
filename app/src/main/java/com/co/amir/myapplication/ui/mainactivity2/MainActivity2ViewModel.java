package com.co.amir.myapplication.ui.mainactivity2;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;

import com.co.amir.myapplication.model.Person;

public class MainActivity2ViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public final ObservableField<String> text=new ObservableField<>();
    public final ObservableArrayList<Person> people =new ObservableArrayList<>();

    public ObservableField<String> getText() {
        return text;
    }

    public ObservableArrayList<Person> getPeople() {
        return people;
    }

    public void btnClick() {
        Log.d("btn_click","the button was pressed");
        text.set("hello");
    }

    public void btnRec(){

    }
}
