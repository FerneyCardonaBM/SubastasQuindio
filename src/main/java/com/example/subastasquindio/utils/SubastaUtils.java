package com.example.subastasquindio.utils;

import com.example.subastasquindio.model.Enums.TipoProducto;
import com.example.subastasquindio.model.Producto;
import com.example.subastasquindio.model.Subasta;

public class SubastaUtils {

    public static Subasta inicializarDatos() {
        Subasta subasta = new Subasta();

        Producto producto = new Producto();
        producto.setNombre("juan 2");
        producto.setId("arias");
        producto.setTipoProducto(TipoProducto.BIENRAIZ);
        subasta.getListaProductos().add(producto);
        System.out.println("Información de la subasta creada");
        return subasta;
    }

}
