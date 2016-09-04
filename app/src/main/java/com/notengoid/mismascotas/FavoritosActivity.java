package com.notengoid.mismascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {
    List<Mascota> mascotas;
    private RecyclerView lstMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar =  (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lstMascotas = (RecyclerView) findViewById(R.id.rvFavMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro3,"Miriam",50));
        mascotas.add(new Mascota(R.drawable.canario,"Luis",40));
        mascotas.add(new Mascota(R.drawable.cerdo,"Diana",30));
        mascotas.add(new Mascota(R.drawable.gato,"Henry",30));
        mascotas.add(new Mascota(R.drawable.pez,"Juana",12));

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        lstMascotas.setAdapter(adaptador);
    };

}
