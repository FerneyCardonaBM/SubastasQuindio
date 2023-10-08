package com.example.subastasquindio.model;


import com.example.subastasquindio.model.Enums.TipoProducto;

import java.io.Serializable;

public class Producto  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private TipoProducto tipoProducto;

    public Producto() {

    }

    // Getters y Setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

