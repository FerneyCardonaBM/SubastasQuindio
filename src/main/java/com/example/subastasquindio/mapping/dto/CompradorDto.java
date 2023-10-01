package com.example.subastasquindio.mapping.dto;

import com.example.subastasquindio.model.Usuario;

public record CompradorDto (
        String nombre,
        String apellido,
        String cedula,
        int edad,
        String telefono,
        String direccion){

}



