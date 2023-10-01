package com.example.subastasquindio.controller.services;


import com.example.subastasquindio.controller.ModelFactoryController;
import com.example.subastasquindio.mapping.dto.CompradorDto;

import java.util.List;

public interface IModelFactoryService {


    List<CompradorDto> obtenerCompradores();
    boolean agregarComprador(CompradorDto compradorDto);

    boolean eliminarComprador(String cedula);

    boolean actualizarComprador(String cedulaActual, CompradorDto compradorDto);

}