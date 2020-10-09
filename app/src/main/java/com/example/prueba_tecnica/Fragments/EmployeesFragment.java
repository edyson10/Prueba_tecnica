package com.example.prueba_tecnica.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba_tecnica.Adapter.Adapter_customers;
import com.example.prueba_tecnica.Adapter.Adapter_employees;
import com.example.prueba_tecnica.Clases.Customers;
import com.example.prueba_tecnica.Clases.Employees;
import com.example.prueba_tecnica.R;

import java.util.ArrayList;

public class EmployeesFragment extends Fragment {

    ArrayList<Employees> listEmployees;
    RecyclerView recyclerEmployees;
    View view;
    private OnFragmentInteractionListener mListener;

    public EmployeesFragment() {
        // Required empty public constructor
    }

    public static EmployeesFragment newInstance(String param1, String param2) {
        EmployeesFragment fragment = new EmployeesFragment();
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
        listEmployees = new ArrayList<>();
        llenarRecycler();
        recyclerEmployees = (RecyclerView) view.findViewById(R.id.recyclerEmployees);
        recyclerEmployees.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adapter_employees adapter = new Adapter_employees(listEmployees);
        recyclerEmployees.setAdapter(adapter);
        return view;
    }

    public void llenarRecycler() {
        listEmployees.add(new Employees("Edyson Fabian Leal Marin", "10909090909", "Administrador", R.drawable.person));
        listEmployees.add(new Employees("Matias David Barbosa Leal", "0987654321", "Vendedor", R.drawable.person));
        listEmployees.add(new Employees("Alexandra Medina Freites", "10934567809","Bodega", R.drawable.person));
        listEmployees.add(new Employees("Edyson El Guapo Leal", "1093534535", "Caja",  R.drawable.person));
    }

    // TODO: Rename method, update argument and hook method into UI event
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
