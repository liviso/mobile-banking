package com.certificatic.mobilebanking.retrofit;

import com.certificatic.mobilebanking.retrofit.request.RequestLogin;
import com.certificatic.mobilebanking.retrofit.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/api/v1/login")
    Call<UserResponse>doLogin(@Body RequestLogin requestLogin);
}
