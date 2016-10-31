package com.notengoid.mismascotas.restApi.model;

import com.notengoid.mismascotas.model.Mascota;

import java.util.ArrayList;

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getContactos() {
        return mascotas;
    }

    public void setContactos(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
