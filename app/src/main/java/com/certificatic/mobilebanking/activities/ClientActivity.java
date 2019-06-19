package com.certificatic.mobilebanking.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.certificatic.mobilebanking.R;
import com.certificatic.mobilebanking.adapters.ClientAdapter;
import com.certificatic.mobilebanking.retrofit.ClientService;
import com.certificatic.mobilebanking.retrofit.CustomerClient;
import com.certificatic.mobilebanking.retrofit.response.ClientResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ClientService clientService;
    CustomerClient customerClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
        retrieveClients();
    }

    private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerClient= CustomerClient.getInstance();
        clientService= customerClient.getclientService();
    }

    private void retrieveClients(){
        Call<List<ClientResponse>> call= clientService.getClients();
        call.enqueue(new Callback<List<ClientResponse>>() {
            @Override
            public void onResponse(Call<List<ClientResponse>> call, Response<List<ClientResponse>> response) {
                if(response.isSuccessful()){
                    if(response.raw().body()!=null){

                        List<ClientResponse> clients= (List<ClientResponse>) response.body();
                        ClientAdapter clientAdapter= new ClientAdapter(ClientActivity.this, clients);
                        recyclerView.setAdapter(clientAdapter);
                    }else{
                        Toast.makeText(ClientActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(ClientActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ClientResponse>> call, Throwable t) {
                Toast.makeText(ClientActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
