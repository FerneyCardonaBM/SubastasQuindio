package com.example.subastasquindio.model;

import com.example.subastasquindio.exceptions.ProductoException;
import com.example.subastasquindio.model.Enums.TipoProducto;
import com.example.subastasquindio.model.services.ISubastaService;

import java.util.ArrayList;

public class Subasta implements ISubastaService {
    private static final long serialVersionUID = 1L;
     ArrayList<Usuario> listaUsuarios  = new ArrayList<>();;
     ArrayList<Comprador> listaCompradores   = new ArrayList<>();;
     ArrayList<Anunciante> listaAnunciantes  = new ArrayList<>();;
    ArrayList<Producto> listaProductos  = new ArrayList<>();;

    public Subasta() {

    }


    // Getters y Setters para los atributos
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Comprador> getListaCompradores() {
        return listaCompradores;
    }

    public void setListaCompradores(ArrayList<Comprador> listaCompradores) {
        this.listaCompradores = listaCompradores;
    }

    public ArrayList<Anunciante> getListaAnunciantes() {
        return listaAnunciantes;
    }

    public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
        this.listaAnunciantes = listaAnunciantes;
    }

    @Override
    public Producto crearProducto(String id, String nombre, TipoProducto tipoProducto) throws ProductoException {
        Producto nuevoProducto = null;
        boolean productoExiste = verificarProductoExistente(id);
        if(productoExiste){
            throw new ProductoException("El producto con id: "+id+" ya existe");
        }else{
            nuevoProducto = new Producto();
            nuevoProducto.setId(id);
            nuevoProducto.setNombre(nombre);
            nuevoProducto.setTipoProducto(tipoProducto);


            getListaProductos().add(nuevoProducto);
        }
        return nuevoProducto;
    }

    public void agregarProducto(Producto nuevoProducto) throws ProductoException{
        getListaProductos().add(nuevoProducto);
    }

    @Override
    public boolean actualizarProducto(String idActual, Producto producto) throws ProductoException {
        Producto productoActual = obtenerProducto(idActual);
        if(productoActual == null)
            throw new ProductoException("El producto a actualizar no existe");
        else{
            productoActual.setId(producto.getId());
            productoActual.setNombre(producto.getNombre());
            productoActual.setTipoProducto(producto.getTipoProducto());

            return true;
        }
    }

    @Override
    public Boolean eliminarProducto(String id) throws ProductoException {
        Producto producto = null;
        boolean flagExiste = false;
        producto = obtenerProducto(id);
        if(producto == null)
            throw new ProductoException("El producto a eliminar no existe");
        else{
            getListaProductos().remove(producto);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean verificarProductoExistente(String id) throws ProductoException {
        if(productoExiste(id)){
            throw new ProductoException("El producto con id: "+id+" ya existe");
        }else{
            return false;
        }
    }


    @Override
    public Producto obtenerProducto(String id) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if(producto.getId().equalsIgnoreCase(id)){
                productoEncontrado = producto;
                break;
            }
        }
        return productoEncontrado;
    }

    @Override
    public ArrayList<Producto> obtenerProductos() {
        return getListaProductos();
    }

    public boolean productoExiste(String id) {
        boolean productoEncontrado = false;
        for (Producto producto : getListaProductos()) {
            if(producto.getId().equalsIgnoreCase(id)){
                productoEncontrado = true;
                break;
            }
        }
        return productoEncontrado;
    }

}

