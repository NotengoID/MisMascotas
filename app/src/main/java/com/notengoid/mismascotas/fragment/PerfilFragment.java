package com.notengoid.mismascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notengoid.mismascotas.R;
import com.notengoid.mismascotas.adapter.MascotaAdaptador;
import com.notengoid.mismascotas.adapter.PerfilAdaptador;
import com.notengoid.mismascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascostas;
    PerfilAdaptador adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);

        rvListaMascostas = (RecyclerView) v.findViewById(R.id.rvDetalleMascota);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        rvListaMascostas.setLayoutManager(glm);
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
        adaptador = new PerfilAdaptador(mascotas,getActivity());
        rvListaMascostas.setAdapter(adaptador);
    };

}
