package com.example.subastasquindio.controller;

import com.example.subastasquindio.controller.services.IModelFactoryService;
import com.example.subastasquindio.exceptions.*;
import com.example.subastasquindio.mapping.dto.CompradorDto;
import com.example.subastasquindio.mapping.mappers.SubastaMapper;
import com.example.subastasquindio.model.*;
import com.example.subastasquindio.model.Subasta;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    Subasta subasta;



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
    public List<CompradorDto> obtenerCompradores() {
        return  mapper.getCompradoresDto(subasta.getListaCompradores());
    }

    @Override
    public boolean agregarComprador(CompradorDto compradorDto) {
        try {
            if (!subasta.verificarCompradorExistente(compradorDto.cedula())) {
                Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
                getSubasta().agregarComprador(comprador);
            }
            return  true;
        } catch (CompradorException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarComprador(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarComprador(cedula);
        } catch (CompradorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarComprador(String cedulaActual, CompradorDto compradorDto) {
        try {
            Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
            getSubasta().actualizarComprador(cedulaActual, comprador);
            return true;
        } catch (CompradorException e) {
            e.printStackTrace();
            return false;
        }
    }
}
