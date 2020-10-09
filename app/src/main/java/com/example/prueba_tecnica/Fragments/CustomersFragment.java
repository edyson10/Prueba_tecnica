package com.example.prueba_tecnica.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba_tecnica.Adapter.Adapter_customers;
import com.example.prueba_tecnica.Clases.Customers;
import com.example.prueba_tecnica.R;

import java.util.ArrayList;

public class CustomersFragment extends Fragment {

    ArrayList<Customers> listCustomer;
    RecyclerView recyclerCustomers;
    View view;
    ImageView addCustomers;
    Adapter_customers adapter;
    private OnFragmentInteractionListener mListener;

    public CustomersFragment() {
        // Required empty public constructor
    }

    public static CustomersFragment newInstance(String param1, String param2) {
        CustomersFragment fragment = new CustomersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_customers, container, false);
        listCustomer = new ArrayList<>();
        llenarRecycler();
        recyclerCustomers = (RecyclerView) view.findViewById(R.id.recyclerClientes);
        recyclerCustomers.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new Adapter_customers(listCustomer);
        recyclerCustomers.setAdapter(adapter);
        addCustomers = view.findViewById(R.id.addCustomers);
        addCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarCliente();
            }
        });

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_edit(recyclerCustomers.getChildAdapterPosition(v));
            }
        });
        return view;
    }

    public void llenarRecycler() {
        listCustomer.add(new Customers("Edyson Fabian Leal Marin", "10909090909", R.drawable.person));
        listCustomer.add(new Customers("Matias David Barbosa Leal", "0987654321", R.drawable.person));
        listCustomer.add(new Customers("Alexandra Medina Freites", "10934567809", R.drawable.person));
        listCustomer.add(new Customers("Edyson El Guapo Leal", "1093534535", R.drawable.person));
    }

    public void agregarCliente() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setView(R.layout.dialog_customers);
        alert.setCancelable(false);
        final AlertDialog alertDialog = alert.create();
        alertDialog.show();

        final EditText nombre, documento;
        Button guardar;
        TextView cancelar;

        nombre = alertDialog.findViewById(R.id.txtNombreCliente);
        documento = alertDialog.findViewById(R.id.txtDocumentoCliente);
        cancelar = alertDialog.findViewById(R.id.btnCancelar);
        guardar = alertDialog.findViewById(R.id.btnAgregarCliente);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().isEmpty() || documento.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Complete los campos", Toast.LENGTH_SHORT).show();
                } else {
                    listCustomer.add(new Customers(nombre.getText().toString(), documento.getText().toString(), R.drawable.person));
                    Toast.makeText(getContext(), "Se ha registrado correctamente", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            }
        });
    }

    public void update_edit(final int posicion) {
        new AlertDialog.Builder(getContext())
                .setIcon(R.drawable.online_shop)
                .setTitle("Cliente")
                .setMessage("¿Que deseas hacer?")
                .setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listCustomer.remove(posicion);
                        Toast.makeText(getContext(), "Se ha eliminado el cliente", Toast.LENGTH_SHORT).show();
                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                })
                .setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mostrarInformacion(posicion);
                    }
                }).show();
    }

    private void mostrarInformacion (final int posicion) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setView(R.layout.dialog_customers);
        alert.setCancelable(false);
        final AlertDialog alertDialog = alert.create();
        alertDialog.show();

        final EditText nombre, documento;
        Button guardar;
        TextView cancelar;

        nombre = alertDialog.findViewById(R.id.txtNombreCliente);
        documento = alertDialog.findViewById(R.id.txtDocumentoCliente);
        cancelar = alertDialog.findViewById(R.id.btnCancelar);
        guardar = alertDialog.findViewById(R.id.btnAgregarCliente);

        nombre.setText(listCustomer.get(posicion).getNombre());
        documento.setText(listCustomer.get(posicion).getDocumento());

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().isEmpty() || documento.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Complete los campos", Toast.LENGTH_SHORT).show();
                } else {
                    listCustomer.get(posicion).setNombre(nombre.getText().toString());
                    listCustomer.get(posicion).setDocumento(documento.getText().toString());
                    Toast.makeText(getContext(), "Se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
