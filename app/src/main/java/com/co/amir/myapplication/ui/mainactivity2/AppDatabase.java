package com.co.amir.myapplication.ui.mainactivity2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.co.amir.myapplication.model.PersonDbModel;

@Database(entities = {PersonDbModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTSNCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTSNCE==null){
            synchronized (AppDatabase.class){
                if(INSTSNCE==null){
                    // create DB here
                    INSTSNCE= Room.databaseBuilder(
                            context.getApplicationContext(),AppDatabase.class,"amiroo_db")
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTSNCE;
    }

    public abstract PersonDao personDao();
}