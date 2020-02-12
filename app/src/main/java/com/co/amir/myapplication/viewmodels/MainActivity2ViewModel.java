package com.co.amir.myapplication.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.co.amir.myapplication.model.PersonDbModel;
import com.co.amir.myapplication.ui.mainactivity2.Repository;

import java.util.List;


public class MainActivity2ViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    public final ObservableField<String> text=new ObservableField<>();
    public final ObservableArrayList<PersonDbModel> people =new ObservableArrayList<>();
    private Repository mRepository;
    private MutableLiveData<List<PersonDbModel>> mAllPerson=new MutableLiveData<>();

    public MainActivity2ViewModel(Application application){
        super(application);
        mRepository=new Repository(application);
        mAllPerson.postValue(mRepository.getAllPersons());

    }

    public LiveData<PersonDbModel> getmAllPerson() {
        return null;
    }
    public void insert(PersonDbModel person){
        mRepository.insert(person);
    }

    public ObservableField<String> getText() {
        return text;
    }

    public ObservableArrayList<PersonDbModel> getPeople() {
        return people;
    }

    public void btnClick() {
        Log.d("btn_click","the button was pressed");
        text.set("hello");

//                        for (PersonDbModel p:getmAllPerson().) {
//                            Log.i("jjjjjjjaj: ",p.name);
//
//                        }

    }

    public void btnRec(){

    }
}
