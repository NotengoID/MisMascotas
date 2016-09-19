package com.notengoid.mismascotas.presentador;

import android.content.Context;
import android.util.Log;

import com.notengoid.mismascotas.model.ConstructorMascotas;
import com.notengoid.mismascotas.model.Mascota;
import com.notengoid.mismascotas.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RVFavoritosPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RVFavoritosPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        Log.e("RVFavoritosPresenter", "cargarMascotas");
        obtenerMascotas();
        Log.e("RVFavoritosPresenter", "cargoMascotas" + mascotas.size());
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTop5Mascotas();
        mostrarMascotasRV();
    }


    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
