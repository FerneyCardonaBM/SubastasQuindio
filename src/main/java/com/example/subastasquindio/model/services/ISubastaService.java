package com.example.subastasquindio.model.services;

import com.example.subastasquindio.exceptions.CompradorException;
import com.example.subastasquindio.exceptions.UsuarioException;
import com.example.subastasquindio.model.Comprador;
import com.example.subastasquindio.model.Usuario;

import java.util.ArrayList;

public interface ISubastaService {
    public Comprador crearComprador(String nombre, String apellido, String cedula, int edad, String telefono, String direccion) throws CompradorException;
    public Boolean eliminarComprador(String cedula)throws CompradorException;
    boolean actualizarComprador(String cedulaActual, Comprador comprador) throws CompradorException;
    public boolean  verificarCompradorExistente(String cedula) throws CompradorException;
    public Comprador obtenerComprador(String cedula);
    public ArrayList<Comprador> obtenerCompradores();
}
