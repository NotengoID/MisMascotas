package com.notengoid.mismascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Mascota> mascotas;
    private RecyclerView lstMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar =  (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        lstMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this, FavoritosActivity.class);
        startActivity(intent);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1,"Juan"));
        mascotas.add(new Mascota(R.drawable.perro2,"Andres"));
        mascotas.add(new Mascota(R.drawable.perro3,"Miriam"));
        mascotas.add(new Mascota(R.drawable.arana,"Roberto"));
        mascotas.add(new Mascota(R.drawable.canario,"Luis"));
        mascotas.add(new Mascota(R.drawable.cerdo,"Diana"));
        mascotas.add(new Mascota(R.drawable.conejo,"Jose"));
        mascotas.add(new Mascota(R.drawable.gato,"Henry"));
        mascotas.add(new Mascota(R.drawable.pez,"Juana"));
        mascotas.add(new Mascota(R.drawable.tortuga,"Carlos"));

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        lstMascotas.setAdapter(adaptador);
    };
}
