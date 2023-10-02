package com.example.subastasquindio.controller;

import com.example.subastasquindio.controller.services.IProductoControllerService;
import com.example.subastasquindio.mapping.dto.ProductoDto;

import java.util.List;

public class ProductoControllerService implements IProductoControllerService {

    ModelFactoryController modelFactoryController;
    public ProductoControllerService(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<ProductoDto> obtenerProductos() {
        return modelFactoryController.obtenerProductos();
    }

    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        return modelFactoryController.agregarProducto(productoDto);
    }

    @Override
    public boolean eliminarProducto(String id) {
        return modelFactoryController.eliminarProducto(id);
    }

    @Override
    public boolean actualizarProducto(String idActual, ProductoDto productoDto) {
        return modelFactoryController.actualizarProducto(idActual, productoDto);
    }

}
