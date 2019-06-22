package com.certificatic.mobilebanking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.certificatic.mobilebanking.R;
import com.certificatic.mobilebanking.adapters.ClientAdapter;
import com.certificatic.mobilebanking.adapters.OnItemClicked;
import com.certificatic.mobilebanking.retrofit.client.CustomerClient;
import com.certificatic.mobilebanking.retrofit.model.Client;
import com.certificatic.mobilebanking.retrofit.service.ClientService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientActivity extends AppCompatActivity implements OnItemClicked
{

    RecyclerView recyclerView;
    ClientService clientService;
    CustomerClient customerClient;
    AlertDialog dialog;
    View cView;
    List<Client> clients;
    ClientAdapter clientAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        retrieveClients();
        showAlertDialog();
    }



    private void init()
    {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerClient = CustomerClient.getInstance();
        clientService = customerClient.getclientService();

    }



    private void retrieveClients()
    {
        Call<List<Client>> call = clientService.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response)
            {
                if(response.isSuccessful()) {
                    if(response.raw().body() != null) {

                        clients = (List<Client>)response.body();
                        clientAdapter = new ClientAdapter(ClientActivity.this, clients);
                        recyclerView.setAdapter(clientAdapter);
                        clientAdapter.setOnClick(ClientActivity.this);

                    }
                    else {
                        Toast.makeText(ClientActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(ClientActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<List<Client>> call, Throwable t)
            {
                Toast.makeText(ClientActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()) {
            case R.id.menuLogout :
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }



    private void showAlertDialog()
    {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ClientActivity.this);
                cView = getLayoutInflater().inflate(R.layout.dialog_add_client, null);
                mBuilder.setView(cView);
                dialog = mBuilder.create();

                dialog.show();
                dialog.getWindow().setLayout(950, 1200);

            }
        });
    }



    public void addClient(View view)
    {
        dialog.dismiss();

        EditText nameEt = cView.findViewById(R.id.nameEt);
        EditText lastNameEt = cView.findViewById(R.id.lastNameEt);
        EditText ageEd = cView.findViewById(R.id.ageEt);
        EditText addressEt = cView.findViewById(R.id.addressEt);
        RadioGroup genderRg = cView.findViewById(R.id.genderRg);

        int selectId = genderRg.getCheckedRadioButtonId();

        RadioButton gender = cView.findViewById(selectId);

        Client client = new Client();
        client.setNombre(nameEt.getText().toString());
        client.setApellidos(lastNameEt.getText().toString());
        client.setEdad(Integer.parseInt(ageEd.getText().toString()));
        client.setDireccion(addressEt.getText().toString());
        ClientResponseForAdd clientResponseForAdd = new ClientResponseForAdd();
        client.setGenero(gender.getText().toString());
        Call<Client> call = clientService.addClient(client);
        call.enqueue(clientResponseForAdd);
    }

    class ClientResponseForAdd implements Callback<Client>
    {

        @Override
        public void onResponse(Call<Client> call, Response<Client> response)
        {
            if(response.code() == 200) {
                Toast.makeText(ClientActivity.this, "Se agrego correctamente.", Toast.LENGTH_SHORT).show();
                Client client = response.body();
                clients.add(client);
                recyclerView.setAdapter(clientAdapter);
            }

        }



        @Override
        public void onFailure(Call<Client> call, Throwable t)
        {
            Toast.makeText(ClientActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onItemClick(final int position)
    {

        Call<Void> call = clientService.removeClient(clients.get(position).getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() ==200){
                    Toast.makeText(ClientActivity.this, "El cliente se eliminó exitosamente.", Toast.LENGTH_SHORT).show();
                    clients.remove(position);
                    recyclerView.setAdapter(clientAdapter);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ClientActivity.this, "Error. Intente más tarde", Toast.LENGTH_SHORT).show();

            }
        });
    }



}