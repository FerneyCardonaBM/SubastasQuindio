package com.example.subastasquindio.model.services;

import com.example.subastasquindio.exceptions.ProductoException;
import com.example.subastasquindio.model.Enums.TipoProducto;
import com.example.subastasquindio.model.Producto;

import java.util.ArrayList;

public interface ISubastaService  {
    public Producto crearProducto(String id, String nombre, TipoProducto tipoProducto) throws ProductoException;
    public Boolean eliminarProducto(String id)throws ProductoException;
    boolean actualizarProducto(String idActual, Producto producto) throws ProductoException;
    public boolean  verificarProductoExistente(String id) throws ProductoException;
    public Producto obtenerProducto(String id);
    public ArrayList<Producto> obtenerProductos();
}
