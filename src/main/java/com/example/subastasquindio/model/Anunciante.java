package com.example.subastasquindio.model;

import java.util.ArrayList;

public class Anunciante extends Persona {
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

