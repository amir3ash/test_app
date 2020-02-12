package com.co.amir.myapplication.ui.mainactivity2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.co.amir.myapplication.model.PersonDbModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Repository {
    private   PersonDao personDao;
    private List<PersonDbModel> allPersons;

    public Repository(Context application){
        AppDatabase db=AppDatabase.getDatabase(application);
        personDao=db.personDao();
       Disposable disposable= personDao.getAll().subscribeOn(Schedulers.newThread()).subscribe(new Consumer<List<PersonDbModel>>() {
            @Override
            public void accept(List<PersonDbModel> people) throws Exception {
                allPersons=people;
                for (PersonDbModel p:people
                     ) {
                    Log.i("tagWithA", "accept: "+p.uid);
                    Thread.sleep(500);

                }
            }
        });
//       disposable.dispose();
    }

    public List<PersonDbModel> getAllPersons() {
        // allPersons=personDao.getAll();
         return  allPersons;
    }

    public void insert(PersonDbModel person){
        Observable.just(person).subscribeOn(Schedulers.io()).delay(500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<PersonDbModel>() {
                    @Override
                    public void accept(PersonDbModel person) throws Exception {
                        personDao.insertAll(person);
                    }
                });
//        new InsertToDB(personDao).doInBackground(person);
//        Observable.just(allPersons)
//                .subscribeOn(Schedulers.io())
//                .map(new Function<LiveData<List<PersonDbModel>>,Void>() {
//                    @Override
//                    public Void apply(LiveData<List<PersonDbModel>> listLiveData) throws Exception {
//                        personDao.insertAll(listLiveData.getValue().get(0));
//                        return null;
//                    }
//                });
    }

    private class InsertToDB extends AsyncTask<PersonDbModel,Void,Void>{
        private PersonDao personDao;

        InsertToDB(PersonDao personDao){
            this.personDao=personDao;
        }

        @Override
        protected Void doInBackground(PersonDbModel... people) {
            personDao.insertAll(people[0]);
            return null;
        }
    }
}
