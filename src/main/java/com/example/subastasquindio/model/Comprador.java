package com.example.subastasquindio.model;

import java.util.ArrayList;

public class Comprador extends Persona {

    private String direccion;
    private ArrayList<Puja> listaPujas = new ArrayList<Puja>();;

    public Comprador() {
    }

    public ArrayList<Puja> getListaPujas() {
        return listaPujas;
    }

    public void setListaPujas(ArrayList<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

