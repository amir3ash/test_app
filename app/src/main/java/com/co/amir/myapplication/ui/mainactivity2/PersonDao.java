package com.co.amir.myapplication.ui.mainactivity2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.co.amir.myapplication.model.Person;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PersonDao{
    @Query("SELECT * FROM person")
    Flowable<List<Person>> getAll();

    @Query("SELECT * FROM person WHERE uid IN (:uIDs)")
    Flowable<Person> loadAllByIds(int[] uIDs);

    @Query("SELECT * FROM person WHERE name LIKE :name AND age LIKE :age LIMIT 1")
    Single<Person> findByName(String name, String age);

    @Insert
    void insertAll(Person people);

    @Delete
    void delete(Person person);
}

