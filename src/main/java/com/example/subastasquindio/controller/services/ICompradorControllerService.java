package com.example.subastasquindio.controller.services;

import com.example.subastasquindio.mapping.dto.CompradorDto;

import java.util.List;

public interface ICompradorControllerService {

    List<CompradorDto> obtenerCompradores();
    boolean agregarComprador(CompradorDto compradorDto);

    boolean eliminarComprador(String cedula);

    boolean actualizarComprador(String cedulaActual, CompradorDto compradorDto);
}
