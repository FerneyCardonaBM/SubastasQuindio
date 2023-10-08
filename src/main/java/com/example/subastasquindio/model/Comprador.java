package com.example.subastasquindio.model;

import java.io.Serializable;

public class Comprador extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private String direccion;
   // ArrayList<Puja> listaPujas = new ArrayList<Puja>();;

    public Comprador() {
    }

   /* public ArrayList<Puja> getListaPujas() {
        return listaPujas;
    }

    public void setListaPujas(ArrayList<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }*/

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

