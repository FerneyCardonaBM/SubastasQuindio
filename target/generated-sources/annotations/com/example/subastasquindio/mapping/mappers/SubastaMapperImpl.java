package com.example.subastasquindio.mapping.mappers;

import com.example.subastasquindio.mapping.dto.ProductoDto;
import com.example.subastasquindio.model.Producto;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-02T14:09:29-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
*/
public class SubastaMapperImpl implements SubastaMapper {

    @Override
    public ProductoDto productoToProductoDto1(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        String id = null;
        String nombre = null;

        id = producto.getId();
        nombre = producto.getNombre();

        ProductoDto productoDto = new ProductoDto( id, nombre );

        return productoDto;
    }

    @Override
    public Producto productoDtoToProducto1(ProductoDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setNombre( productoDto.nombre() );
        producto.setId( productoDto.id() );

        return producto;
    }

    @Override
    public List<ProductoDto> getListProductosDto1(List<Producto> listProductos) {
        if ( listProductos == null ) {
            return null;
        }

        List<ProductoDto> list = new ArrayList<ProductoDto>( listProductos.size() );
        for ( Producto producto : listProductos ) {
            list.add( productoToProductoDto1( producto ) );
        }

        return list;
    }
}
