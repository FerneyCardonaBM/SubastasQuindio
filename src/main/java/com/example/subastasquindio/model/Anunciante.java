package com.example.subastasquindio.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Anunciante extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();;

    public Anunciante() {
    }

    public ArrayList<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}

