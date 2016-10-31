package com.notengoid.mismascotas.presentador;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.notengoid.mismascotas.R;
import com.notengoid.mismascotas.db.BaseDatos;
import com.notengoid.mismascotas.model.ConstructorMascotas;
import com.notengoid.mismascotas.model.Mascota;
import com.notengoid.mismascotas.restApi.ConstantesRestApi;
import com.notengoid.mismascotas.restApi.EndpointsApi;
import com.notengoid.mismascotas.restApi.adapter.RestApiAdapter;
import com.notengoid.mismascotas.restApi.model.MascotaResponse;
import com.notengoid.mismascotas.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private String userToken = null;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;

        BaseDatos db = new BaseDatos(context);

        if(db.obtenerMascota().compareTo("")==0){
            Log.e("RecyclerViewFragment", "insert");
            ContentValues contentValues = new ContentValues();
            contentValues.put("id","1");
            contentValues.put("nombre","323216765.a94a053.fc442c9cc030426098487d879ad05d32");
            contentValues.put("foto","1");
            db.insertarMascota(contentValues);
        }

        userToken = db.obtenerMascota();
        Log.e("RecyclerViewFragment", userToken);
        obtenerMediosRecientes();

    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia(userToken);

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getContactos();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
