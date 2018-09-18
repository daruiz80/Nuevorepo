package com.example.senasoft_1.registrovehiculo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senasoft_1.registrovehiculo.Dbsqlite.Dbsqlite;
import com.example.senasoft_1.registrovehiculo.Fragmentos.FragmentCapacidad;
import com.example.senasoft_1.registrovehiculo.Fragmentos.FragmentInformes;
import com.example.senasoft_1.registrovehiculo.Fragmentos.FragmentRegistro;
import com.example.senasoft_1.registrovehiculo.Pojos.Pojos;
import com.example.senasoft_1.registrovehiculo.Utils.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentCapacidad.OnFragmentInteractionListener{

    String cantiCarros,cantiMotos;
    int cantiAutos,cantiMot;
    FragmentCapacidad fragmentCapacidad=new FragmentCapacidad();
    Dbsqlite dbsqlite=new Dbsqlite(this,"",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*SharedPreferences preferencesOne=getSharedPreferences("mxCarros",Context.MODE_PRIVATE);
        cantiCarros=preferencesOne.getString(String.valueOf(Utils.NUMMXAUTOS),"");

        SharedPreferences preferencesTwo=getSharedPreferences("mxMotos",Context.MODE_PRIVATE);
        cantiMotos=preferencesTwo.getString(String.valueOf(Utils.NUMMXMOTOS),"");*/



    }

    public void addFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framehome,fragment);
        transaction.commit();
    }

    public void btnItems(View view) {
        switch (view.getId()){
            case R.id.registrar:
                cantiAutos=Integer.parseInt(cantiCarros);
                cantiMot=Integer.parseInt(cantiMotos);
                Toast.makeText(this,cantiAutos +"--"+cantiMot,Toast.LENGTH_SHORT).show();
                if (cantiAutos>0 && cantiMot>0){
                    addFragment(FragmentRegistro.newInstance(1));
                }else{
                    Toast.makeText(this,"Debe definir las capacidades máximas del parqueadero",Toast.LENGTH_SHORT).show();
                    addFragment(FragmentCapacidad.newInstance(2));
                }

                break;

            case R.id.capacidad:
                addFragment(FragmentCapacidad.newInstance(2));

                break;

            case R.id.informes:
                 addFragment(FragmentInformes.newInstance(3));
            break;


            case R.id.salir:
                System.exit(0);
                break;
        }
    }


    @Override
    public void onFragmentInteraction(Pojos pojos) {
        long verfica=dbsqlite.insertCanti(pojos);
        if (verfica>0){
            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
        }
    }
}
