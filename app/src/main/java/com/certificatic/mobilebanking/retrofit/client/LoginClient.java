package com.certificatic.mobilebanking.retrofit.client;

import com.certificatic.mobilebanking.common.Constants;
import com.certificatic.mobilebanking.retrofit.service.LoginService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
    private static LoginClient instance = null;

    private LoginService loginService;
    private Retrofit retrofit;

    private LoginClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_LOGIN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loginService = retrofit.create(LoginService.class);
    }

    public static LoginClient getInstance() {
        if (instance == null) {
            instance = new LoginClient();
        }
        return instance;
    }

    public LoginService getLoginService() {
        return loginService;
    }

}
