package com.notengoid.mismascotas.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.notengoid.mismascotas.R;
import com.notengoid.mismascotas.db.BaseDatos;
import com.notengoid.mismascotas.db.ConstantesBaseDatos;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        if(db.obtenerTodasLasMascotas().size() == 0){
            insertarMascotas(db);
        }

        return  db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerTop5Mascotas() {
        BaseDatos db = new BaseDatos(context);

        if(db.obtenerTodasLasMascotas().size() == 0){
            insertarMascotas(db);
        }

        return  db.obtenerTop5Mascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        String[] nomMascotas = new String[]{"Juan","Andres","Miriam","Roberto","Luis","Diana",
                "Jose","Henry","Juana","Carlos"};
        int[] imgMascotas = new int[]{R.drawable.perro1, R.drawable.perro2,R.drawable.perro3,
                R.drawable.arana, R.drawable.canario, R.drawable.cerdo, R.drawable.conejo,
                R.drawable.gato, R.drawable.pez, R.drawable.tortuga};

        for(int i = 0; i < nomMascotas.length; i++){
            contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, nomMascotas[i]);
            contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, imgMascotas[i]);
            db.insertarMascota(contentValues);
        }
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_LIKESMASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}