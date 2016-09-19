package com.notengoid.mismascotas.vista.fragment;

import com.notengoid.mismascotas.adapter.MascotaAdaptador;
import com.notengoid.mismascotas.model.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
