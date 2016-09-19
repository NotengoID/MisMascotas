package com.notengoid.mismascotas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.notengoid.mismascotas.adapter.MascotaAdaptador;
import com.notengoid.mismascotas.model.Mascota;
import com.notengoid.mismascotas.presentador.IRecylerViewFragmentPresenter;
import com.notengoid.mismascotas.presentador.RVFavoritosPresenter;
import com.notengoid.mismascotas.presentador.RecyclerViewFragmentPresenter;
import com.notengoid.mismascotas.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity implements IRecyclerViewFragmentView {
    List<Mascota> mascotas;
    private Activity activity;
    private RecyclerView rvFavMascotas;
    private IRecylerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar =  (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activity = this;
        rvFavMascotas = (RecyclerView) findViewById(R.id.rvFavMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, this.getApplicationContext());


        /*lstMascotas = (RecyclerView) findViewById(R.id.rvFavMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();*/
    }

    /*public void inicializarListaContactos(){
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
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, activity);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvFavMascotas.setAdapter(adaptador);
    }
}
