package com.certificatic.mobilebanking.retrofit.client;

import com.certificatic.mobilebanking.common.Constants;
import com.certificatic.mobilebanking.retrofit.service.ClientService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerClient {
    private static CustomerClient instance = null;

    private ClientService clientService;
    private Retrofit retrofit;

    private CustomerClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_CLIENT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        clientService = retrofit.create(ClientService.class);
    }

    public static CustomerClient getInstance() {
        if (instance == null) {
            instance = new CustomerClient();
        }
        return instance;
    }

    public ClientService getclientService() {
        return clientService;
    }
}
class ManageAddClient{

}