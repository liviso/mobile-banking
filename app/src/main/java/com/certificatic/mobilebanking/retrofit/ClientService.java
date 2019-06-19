package com.certificatic.mobilebanking.retrofit;

import com.certificatic.mobilebanking.retrofit.response.ClientResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ClientService {

    @GET("/api/v1/cliente")
    Call  <List<ClientResponse>> getClients();
}
