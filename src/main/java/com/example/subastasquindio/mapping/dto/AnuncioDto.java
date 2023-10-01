package com.example.subastasquindio.mapping.dto;

import com.example.subastasquindio.model.Producto;

public record AnuncioDto(
         Producto producto,
         String descripcion,
         String foto,
         String nombreAnunciante,
         String fechaPublicacion,
         String fechaCaducidad,
         Double valorInicial)
{
}
