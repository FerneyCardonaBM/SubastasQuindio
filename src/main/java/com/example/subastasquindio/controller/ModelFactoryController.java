package com.example.subastasquindio.controller;

import com.example.subastasquindio.controller.services.IModelFactoryService;
import com.example.subastasquindio.exceptions.*;
import com.example.subastasquindio.mapping.dto.ProductoDto;
import com.example.subastasquindio.mapping.mappers.SubastaMapper;
import com.example.subastasquindio.model.*;
import com.example.subastasquindio.model.Subasta;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    Subasta subasta = new Subasta();



      SubastaMapper mapper = SubastaMapper.INSTANCE.INSTANCE;
    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");

    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta banco) {
        this.subasta = subasta;
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        return  mapper.getListProductosDto1(subasta.getListaProductos());
    }

    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        try {
            if (!subasta.verificarProductoExistente(productoDto.id())) {
                Producto producto = mapper.productoDtoToProducto1(productoDto);
                getSubasta().agregarProducto(producto);
            }
            return  true;
        } catch (ProductoException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarProducto(id);
        } catch (ProductoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarProducto(String idActual, ProductoDto productoDto) {
        try {
            Producto producto = mapper.productoDtoToProducto1(productoDto);
            getSubasta().actualizarProducto(idActual, producto);
            return true;
        } catch (ProductoException e) {
            e.printStackTrace();
            return false;
        }
    }
}
