package com.certificatic.mobilebanking.retrofit.service;

import com.certificatic.mobilebanking.retrofit.model.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ClientService {

    @GET("/api/v1/cliente")
    Call  <List<Client>> getClients();

    @POST("/api/v1/cliente")
    Call <Client> addClient(@Body Client client);
}
