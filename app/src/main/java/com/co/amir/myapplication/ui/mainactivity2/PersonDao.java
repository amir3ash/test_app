package com.co.amir.myapplication.ui.mainactivity2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.co.amir.myapplication.model.PersonDbModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PersonDao{
    @Query("SELECT * FROM PersonDbModel")
    Flowable<List<PersonDbModel>> getAll();

    @Query("SELECT * FROM PersonDbModel WHERE uid IN (:uIDs)")
    Flowable<PersonDbModel> loadAllByIds(int[] uIDs);

    @Query("SELECT * FROM PersonDbModel WHERE name LIKE :name AND age LIKE :age LIMIT 1")
    Single<PersonDbModel> findByName(String name, String age);

    @Insert
    void insertAll(PersonDbModel people);

    @Delete
    void delete(PersonDbModel person);
}

