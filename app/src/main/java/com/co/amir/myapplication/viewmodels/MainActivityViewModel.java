package com.co.amir.myapplication.viewmodels;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.co.amir.myapplication.TokenResponse;
import com.co.amir.myapplication.RetrofitFactory;
import com.co.amir.myapplication.RetrofitSevice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivityViewModel extends ViewModel {

    public ObservableField<String> username=new ObservableField<>();
    public ObservableField<String> password=new ObservableField<>();
    private String token;

    private MutableLiveData<Boolean> changingActivity=new MutableLiveData<>();

    public void btnClick(){
        Retrofit retrofit= RetrofitFactory.getRetrofit();
        RetrofitSevice retrofitSevice=retrofit.create(RetrofitSevice.class);
        Call<TokenResponse> responseCall=retrofitSevice.getToken(username.get(),password.get());
        responseCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response){
                TokenResponse resault=response.body();
                if(response.isSuccessful()) {
                    if (resault != null) {
                        token = resault.token;
                        Log.i("resault", resault.token);
                        changingActivity.setValue(true);
                    }
                    Log.e("respose error","code"+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
       // Log.d("btn_C",username.get()+"  "+password.get());
    }

    public MutableLiveData<Boolean> getChangingActivity() {
        return changingActivity;
    }

    public String getToken() {
        return token;
    }
}
