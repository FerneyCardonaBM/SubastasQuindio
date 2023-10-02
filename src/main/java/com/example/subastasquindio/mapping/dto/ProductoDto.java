package com.example.subastasquindio.mapping.dto;
import com.example.subastasquindio.model.Enums.TipoProducto;

public record ProductoDto(
        String id,
        String nombre,
        TipoProducto tipoProducto
) {
}
