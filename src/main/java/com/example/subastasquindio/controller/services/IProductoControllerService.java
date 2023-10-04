package com.example.subastasquindio.controller.services;

import com.example.subastasquindio.mapping.dto.CompradorDto;
import com.example.subastasquindio.mapping.dto.ProductoDto;

import java.util.List;

public interface IProductoControllerService {

    List<ProductoDto> obtenerProductos();
    boolean agregarProducto(ProductoDto productoDto);

    boolean eliminarProducto(String id);

    boolean actualizarProducto(String idActual,ProductoDto productoDto);

    /// registrarAcciones
}
