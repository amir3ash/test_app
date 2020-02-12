package com.co.amir.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitSevice {
    @FormUrlEncoded
    @POST("/myapp/api-token-auth/")
    Call<TokenResponse> getToken(@Field("username")String username, @Field("password")String pass);

    @FormUrlEncoded
    @POST("/create-user")
    Call<UserCreateResponse> createUser(@Field("username")String user,@Field("password")String pass,
                                        String email,String name);
   // @FormUrlEncoded
  //  @POST("")
   // Call<> login(@Header("")String token);

}
