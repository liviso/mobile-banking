package com.certificatic.mobilebanking.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.certificatic.mobilebanking.R;
import com.certificatic.mobilebanking.retrofit.response.ClientResponse;

import java.util.List;

public class ClientAdapter  extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder>{

    private List<ClientResponse> clients;
    private Context context;

    public ClientAdapter(Context ctx, List<ClientResponse> clients){
        this.clients=clients;
        this.context=ctx;
    }
    @NonNull
    @Override
    public ClientAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_clients, null);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ClientViewHolder holder, int position) {
        ClientResponse client= clients.get(position);

        holder.clientNameTx.setText(client.getNombre());
        holder.clienteGenderTx.setText(client.getSexo());
        holder.clientAgeTx.setText(client.getEdad().toString());
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    class ClientViewHolder extends RecyclerView.ViewHolder {

        TextView clientNameTx, clientAgeTx, clienteGenderTx;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            clientNameTx= itemView.findViewById(R.id.clientName);
            clientAgeTx= itemView.findViewById(R.id.clientAge);
            clienteGenderTx= itemView.findViewById(R.id.clientGender);
        }
    }
}
