package com.notengoid.mismascotas.vista.fragment;

import com.notengoid.mismascotas.adapter.MascotaFavoritaAdaptador;
import com.notengoid.mismascotas.model.Mascota;

import java.util.ArrayList;

public interface IRVFavoritosView {

    public void generarLinearLayoutVertical();

    public MascotaFavoritaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaFavoritaAdaptador adaptador);
}
