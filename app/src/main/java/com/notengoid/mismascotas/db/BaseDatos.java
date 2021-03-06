package com.notengoid.mismascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.notengoid.mismascotas.model.Mascota;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTA + "(" +
                ConstantesBaseDatos.TABLA_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_MASCOTA_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLA_LIKESMASCOTA + "(" +
                ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLA_LIKESMASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTA + "(" + ConstantesBaseDatos.TABLA_MASCOTA_ID + ")" +
                ")";

        String queryCrearTablaConfiguracion = "CREATE TABLE " + ConstantesBaseDatos.TABLA_CONFIGURACION + "(" +
                ConstantesBaseDatos.TABLA_CONFIGURACION_ID + " TEXT, " +
                ConstantesBaseDatos.TABLA_CONFIGURACION_VALOR + " TEXT )";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
        db.execSQL(queryCrearTablaConfiguracion);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_LIKESMASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_CONFIGURACION);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        /*
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTA ;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreCompleto(registros.getString(1));
            mascotaActual.setUrlFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLA_LIKESMASCOTA_NUMERO_LIKES+") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLA_LIKESMASCOTA +
                                " WHERE " + ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();
        */
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTA,null, contentValues);
        db.close();
    }

    public void updateMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLA_MASCOTA,contentValues, null, null);
        db.close();
    }

    public String obtenerMascota(){
        String token = "";
        String query = "SELECT " + ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE +
                " FROM " + ConstantesBaseDatos.TABLA_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLA_MASCOTA_ID + "= 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            token = registros.getString(0);
        }

        db.close();
        return token;
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_LIKESMASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLA_LIKESMASCOTA_NUMERO_LIKES+")" +
                        " FROM " + ConstantesBaseDatos.TABLA_LIKESMASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

    public void borrarBD(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(ConstantesBaseDatos.TABLA_LIKESMASCOTA,"",null);
        db.delete(ConstantesBaseDatos.TABLA_MASCOTA, "",null);
        db.delete(ConstantesBaseDatos.TABLA_CONFIGURACION, "",null);
        db.close();
    }

    public ArrayList<Mascota> obtenerTop5Mascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        /*
        String query = "SELECT m.*, COUNT(ml." + ConstantesBaseDatos.TABLA_LIKESMASCOTA_NUMERO_LIKES +  ") "+
                        "FROM " + ConstantesBaseDatos.TABLA_MASCOTA + " as m, " +
                                ConstantesBaseDatos.TABLA_LIKESMASCOTA + " as ml " +
                        "WHERE ml." + ConstantesBaseDatos.TABLA_LIKESMASCOTA_ID_MASCOTA + " = m." + ConstantesBaseDatos.TABLA_MASCOTA_ID + " " +
                        "GROUP BY m." + ConstantesBaseDatos.TABLA_MASCOTA_ID + " " +
                        "ORDER BY COUNT(ml." + ConstantesBaseDatos.TABLA_LIKESMASCOTA_NUMERO_LIKES + ") DESC LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setUrlFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();
        */
        return mascotas;
    }

    public void insertarCONFIGURACION(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_CONFIGURACION,null, contentValues);
        db.close();
    }
}