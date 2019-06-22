package com.certificatic.mobilebanking.retrofit.service;

import com.certificatic.mobilebanking.retrofit.model.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ClientService {

    @GET("/api/v1/cliente")
    Call  <List<Client>> getClients();

    @POST("/api/v1/cliente")
    Call <Client> addClient(@Body Client client);

    @DELETE("/api/v1/cliente/{id}")
    Call<Void> removeClient(@Path("id") Integer idClient);
}
