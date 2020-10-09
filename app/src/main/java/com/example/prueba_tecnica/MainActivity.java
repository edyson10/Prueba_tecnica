package com.example.prueba_tecnica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.prueba_tecnica.Fragments.AcercaFragment;
import com.example.prueba_tecnica.Fragments.CustomersFragment;
import com.example.prueba_tecnica.Fragments.EmployeesFragment;
import com.example.prueba_tecnica.Fragments.FertilizerFragment;
import com.example.prueba_tecnica.Fragments.ReportFragment;
import com.example.prueba_tecnica.Fragments.SalesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CustomersFragment.OnFragmentInteractionListener,
        EmployeesFragment.OnFragmentInteractionListener, SalesFragment.OnFragmentInteractionListener,
        FertilizerFragment.OnFragmentInteractionListener, ReportFragment.OnFragmentInteractionListener,
        AcercaFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = new CustomersFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).commit();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        alertOneButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            alertOneButton();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment miFragment = null;
        boolean fragmentSeleccionado = false;

        if (id == R.id.nav_customers) {
            // Handle the camera action
            miFragment = new CustomersFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_employees) {
            miFragment = new EmployeesFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_sales) {
            miFragment = new SalesFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_fertilizer) {
            miFragment = new FertilizerFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_report) {
            miFragment = new ReportFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_info) {
            miFragment = new AcercaFragment();
            fragmentSeleccionado = true;
        }

        if (fragmentSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void alertOneButton() {
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.online_shop)
                .setTitle("Sesión")
                .setMessage("¿Desea cerrar sesión?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Se ha cerrado sesión", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
