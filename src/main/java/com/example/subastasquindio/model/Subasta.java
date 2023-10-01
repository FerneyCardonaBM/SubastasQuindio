package com.example.subastasquindio.model;

import com.example.subastasquindio.exceptions.CompradorException;
import com.example.subastasquindio.exceptions.UsuarioException;
import com.example.subastasquindio.model.services.ISubastaService;

import java.util.ArrayList;

public class Subasta implements ISubastaService {
    private static final long serialVersionUID = 1L;
     ArrayList<Usuario> listaUsuarios  = new ArrayList<>();;
     ArrayList<Comprador> listaCompradores   = new ArrayList<>();;
     ArrayList<Anunciante> listaAnunciantes  = new ArrayList<>();;

    public Subasta() {

    }

    // Getters y Setters para los atributos
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
    public Comprador crearComprador(String nombre, String apellido, String cedula, int edad, String telefono, String direccion) throws CompradorException {
        Comprador nuevoComprador = null;
        boolean compradorExiste = verificarCompradorExistente(cedula);
        if(compradorExiste){
            throw new CompradorException("El comprador con cedula: "+cedula+" ya existe");
        }else{
            nuevoComprador = new Comprador();
            nuevoComprador.setNombre(nombre);
            nuevoComprador.setApellido(apellido);
            nuevoComprador.setCedula(cedula);
            nuevoComprador.setEdad(edad);
            nuevoComprador.setTelefono(telefono);
            nuevoComprador.setDireccion(direccion);

            getListaCompradores().add(nuevoComprador);
        }
        return nuevoComprador;
    }

    public void agregarComprador(Comprador nuevoComprador) throws CompradorException{
        getListaCompradores().add(nuevoComprador);
    }

    @Override
    public boolean actualizarComprador(String cedulaActual, Comprador comprador) throws CompradorException {
        Comprador compradorActual = obtenerComprador(cedulaActual);
        if(compradorActual == null)
            throw new CompradorException("El comprador a actualizar no existe");
        else{
            compradorActual.setNombre(comprador.getNombre());
            compradorActual.setApellido(comprador.getApellido());
            compradorActual.setCedula(comprador.getCedula());
            compradorActual.setTelefono(comprador.getTelefono());
            compradorActual.setEdad(comprador.getEdad());
            compradorActual.setDireccion(comprador.getDireccion());
            return true;
        }
    }

    @Override
    public Boolean eliminarComprador(String cedula) throws CompradorException {
        Comprador comprador = null;
        boolean flagExiste = false;
        comprador = obtenerComprador(cedula);
        if(comprador == null)
            throw new CompradorException("El comprador a eliminar no existe");
        else{
            getListaCompradores().remove(comprador);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean verificarCompradorExistente(String cedula) throws CompradorException {
        if(compradorExiste(cedula)){
            throw new CompradorException("El comprador con cedula: "+cedula+" ya existe");
        }else{
            return false;
        }
    }


    @Override
    public Comprador obtenerComprador(String cedula) {
        Comprador compradorEncontrado = null;
        for (Comprador comprador : getListaCompradores()) {
            if(comprador.getCedula().equalsIgnoreCase(cedula)){
                compradorEncontrado = comprador;
                break;
            }
        }
        return compradorEncontrado;
    }

    @Override
    public ArrayList<Comprador> obtenerCompradores() {
        return getListaCompradores();
    }

    public boolean compradorExiste(String cedula) {
        boolean compradorEncontrado = false;
        for (Comprador comprador : getListaCompradores()) {
            if(comprador.getCedula().equalsIgnoreCase(cedula)){
                compradorEncontrado = true;
                break;
            }
        }
        return compradorEncontrado;
    }

}

