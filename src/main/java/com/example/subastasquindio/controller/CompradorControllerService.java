package com.example.subastasquindio.controller;

import com.example.subastasquindio.controller.services.ICompradorControllerService;
import com.example.subastasquindio.mapping.dto.CompradorDto;

import java.util.List;

public class CompradorControllerService implements ICompradorControllerService {

    ModelFactoryController modelFactoryController;
    public CompradorControllerService(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<CompradorDto> obtenerCompradores() {
        return modelFactoryController.obtenerCompradores();
    }

    @Override
    public boolean agregarComprador(CompradorDto compradorDto) {
        return modelFactoryController.agregarComprador(compradorDto);
    }

    @Override
    public boolean eliminarComprador(String cedula) {
        return modelFactoryController.eliminarComprador(cedula);
    }

    @Override
    public boolean actualizarComprador(String cedulaActual, CompradorDto compradorDto) {
        return modelFactoryController.actualizarComprador(cedulaActual, compradorDto);
    }

}
