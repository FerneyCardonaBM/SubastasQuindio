package com.example.subastasquindio.mapping.mappers;

import com.example.subastasquindio.mapping.dto.ProductoDto;
import com.example.subastasquindio.model.Producto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubastaMapper {
    SubastaMapper INSTANCE = Mappers.getMapper(SubastaMapper.class);

    @Named("productoToProductoDto1")
    ProductoDto productoToProductoDto1(Producto producto);

    Producto productoDtoToProducto1(ProductoDto productoDto);

    @IterableMapping(qualifiedByName = "productoToProductoDto1")
    List<ProductoDto> getListProductosDto1(List<Producto> listProductos);
}
