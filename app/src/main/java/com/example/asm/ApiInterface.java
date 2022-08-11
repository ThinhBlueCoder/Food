package com.example.asm;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<ApiResponse> performUserSignIn(@Field("user_name") String userName,
                                        @Field("password") String password,
                                        @Field("name") String name);

    @FormUrlEncoded
    @POST("login.php")
    Call<ApiResponse> performUserLogin(@Field("user_name") String userName,
                                       @Field("password") String password);
}
