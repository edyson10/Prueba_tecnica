package com.example.prueba_tecnica.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba_tecnica.Clases.Customers;
import com.example.prueba_tecnica.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_customers extends RecyclerView.Adapter<Adapter_customers.ViewHolderCustomers> implements View.OnClickListener {

    ArrayList<Customers> listCustomers;
    private View.OnClickListener listener;

    public Adapter_customers (ArrayList<Customers> listCustomers) {
        this.listCustomers = listCustomers;
    }

    @NonNull
    @Override
    public Adapter_customers.ViewHolderCustomers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customers, null, false);
        view.setOnClickListener(this);
        return new Adapter_customers.ViewHolderCustomers(view);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCustomers holder, int position) {
        holder.foto.setImageResource(listCustomers.get(position).getFoto());
        holder.nombre.setText(listCustomers.get(position).getNombre());
        holder.documento.setText(listCustomers.get(position).getDocumento());
    }

    @Override
    public int getItemCount() {
        return listCustomers.size();
    }

    @Override
    public void onClick(View view) {
        if (this.listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolderCustomers extends RecyclerView.ViewHolder {

        TextView nombre, documento;
        ImageView foto;

        public ViewHolderCustomers(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.person_photo);
            nombre = itemView.findViewById(R.id.txtNombre);
            documento = itemView.findViewById(R.id.txtDocumento);
        }
    }
}
