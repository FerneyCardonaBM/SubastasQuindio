package com.example.subastasquindio.mapping.dto;

import com.example.subastasquindio.model.Puja;
import com.example.subastasquindio.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public record CompradorDto (
        String nombre,
        String apellido,
        String cedula,
        Double edad,
        String telefono,
        String direccion){

}



