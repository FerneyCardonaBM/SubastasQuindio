package com.example.subastasquindio.mapping.mappers;
import com.example.subastasquindio.mapping.dto.CompradorDto;
import com.example.subastasquindio.model.Comprador;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubastaMapper {
    SubastaMapper INSTANCE = Mappers.getMapper(SubastaMapper.class);

    @Named("compradorToCompradorDto")
    CompradorDto compradorToCompradorDto(CompradorDto compradorDto);

    Comprador compradorDtoToComprador(CompradorDto compradorDto);

    @IterableMapping(qualifiedByName = "compradorToCompradorDto")
    List<CompradorDto> getCompradoresDto(List<Comprador> listComprador);



}
