package com.co.amir.myapplication.ui.mainactivity2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.co.amir.myapplication.model.Person;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Repository {
    private   PersonDao personDao;
    private List<Person> allPersons;

    Repository(Context application){
        AppDatabase db=AppDatabase.getDatabase(application);
        personDao=db.personDao();
       Disposable disposable= personDao.getAll().subscribeOn(Schedulers.newThread()).subscribe(new Consumer<List<Person>>() {
            @Override
            public void accept(List<Person> people) throws Exception {
                allPersons=people;
                for (Person p:people
                     ) {
                    Log.i("tagWithA", "accept: "+p.uid);
                    Thread.sleep(500);

                }
            }
        });
//       disposable.dispose();
    }

    public List<Person> getAllPersons() {
        // allPersons=personDao.getAll();
         return  allPersons;
    }

    public void insert(Person person){
        Observable.just(person).subscribeOn(Schedulers.io()).delay(500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Person>() {
                    @Override
                    public void accept(Person person) throws Exception {
                        personDao.insertAll(person);
                    }
                });
//        new InsertToDB(personDao).doInBackground(person);
//        Observable.just(allPersons)
//                .subscribeOn(Schedulers.io())
//                .map(new Function<LiveData<List<Person>>,Void>() {
//                    @Override
//                    public Void apply(LiveData<List<Person>> listLiveData) throws Exception {
//                        personDao.insertAll(listLiveData.getValue().get(0));
//                        return null;
//                    }
//                });
    }

    private class InsertToDB extends AsyncTask<Person,Void,Void>{
        private PersonDao personDao;

        InsertToDB(PersonDao personDao){
            this.personDao=personDao;
        }

        @Override
        protected Void doInBackground(Person... people) {
            personDao.insertAll(people[0]);
            return null;
        }
    }
}
