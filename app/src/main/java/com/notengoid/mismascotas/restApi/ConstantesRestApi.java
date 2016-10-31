package com.notengoid.mismascotas.restApi;

/**
 * Created by anahisalgado on 25/05/16.
 */
public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "{token}";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER; // + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String ACCESS_TOKEN_1 = "323216765.a94a053.fc442c9cc030426098487d879ad05d32";
    public static final String ACCESS_TOKEN_2 = "3259702353.aa0d0f4.e61865afc9144ecc8ffc8f6dc84aa17b";
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
}
