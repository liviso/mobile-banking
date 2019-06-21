package com.certificatic.mobilebanking.retrofit.service;

import com.certificatic.mobilebanking.retrofit.model.Login;
import com.certificatic.mobilebanking.retrofit.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/api/v1/login")
    Call<User>doLogin(@Body Login requestLogin);
}
