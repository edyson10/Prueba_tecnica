package com.example.prueba_tecnica.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba_tecnica.Clases.Customers;
import com.example.prueba_tecnica.Clases.Employees;
import com.example.prueba_tecnica.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_employees extends RecyclerView.Adapter<Adapter_employees.ViewHolderEmployees> implements View.OnClickListener {

    ArrayList<Employees> listEmployees;
    private View.OnClickListener listener;

    public Adapter_employees (ArrayList<Employees> listEmployees) {
        this.listEmployees = listEmployees;
    }

    @Override
    public void onClick(View view) {
        if (this.listener != null) {
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public Adapter_employees.ViewHolderEmployees onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employees, null, false);
        view.setOnClickListener(this);
        return new Adapter_employees.ViewHolderEmployees(view);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEmployees holder, int position) {
        holder.foto.setImageResource(listEmployees.get(position).getFoto());
        holder.nombre.setText(listEmployees.get(position).getNombre());
        holder.documento.setText(listEmployees.get(position).getDocumento());
        holder.cargo.setText(listEmployees.get(position).getCargo());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderEmployees extends RecyclerView.ViewHolder {

        TextView nombre, documento, cargo;
        ImageView foto;

        public ViewHolderEmployees(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.photo_employees);
            nombre = itemView.findViewById(R.id.txtNomEmployees);
            documento = itemView.findViewById(R.id.txtDocEmployees);
            cargo = itemView.findViewById(R.id.txtCargoEmployees);
        }
    }
}
