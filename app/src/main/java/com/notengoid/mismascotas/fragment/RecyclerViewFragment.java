package com.notengoid.mismascotas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notengoid.mismascotas.pojo.Mascota;
import com.notengoid.mismascotas.adapter.MascotaAdaptador;
import com.notengoid.mismascotas.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 11/09/2016.
 */
public class RecyclerViewFragment extends Fragment {
    List<Mascota> mascotas;
    private RecyclerView listaContactos;
    MascotaAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);


        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
        return v;
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
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaContactos.setAdapter(adaptador);
    };
}
