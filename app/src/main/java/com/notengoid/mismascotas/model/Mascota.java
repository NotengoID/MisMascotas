package com.notengoid.mismascotas.model;

/**
 * Created by Asus on 4/09/2016.
 */
public class Mascota {
    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes = 0;

    public Mascota(){}

    public Mascota(String urlFoto, String nombreCompleto, int likes){
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public Mascota(String urlFoto, String nombreCompleto){
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = 0;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
