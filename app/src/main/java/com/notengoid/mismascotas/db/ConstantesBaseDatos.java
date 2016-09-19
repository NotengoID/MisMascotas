package com.notengoid.mismascotas.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLA_MASCOTA           = "mascota";
    public static final String TABLA_MASCOTA_ID        = "id";
    public static final String TABLA_MASCOTA_NOMBRE    = "nombre";
    public static final String TABLA_MASCOTA_FOTO      = "foto";

    public static final String TABLA_LIKESMASCOTA = "mascota_likes";
    public static final String TABLA_LIKESMASCOTA_ID = "id";
    public static final String TABLA_LIKESMASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLA_LIKESMASCOTA_NUMERO_LIKES = "numero_likes";
}
