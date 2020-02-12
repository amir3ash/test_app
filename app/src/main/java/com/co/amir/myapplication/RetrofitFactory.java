package com.co.amir.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static Retrofit mRetrofit=null;
    private RetrofitFactory(){}
    public static Retrofit getRetrofit(){
        if(mRetrofit==null){
            mRetrofit=new Retrofit.Builder()
                    .baseUrl("http://192.168.1.105:8000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
