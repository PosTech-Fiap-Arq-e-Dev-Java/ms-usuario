package com.fiap.ms.usuario.adapters.out.repository.mapper;

import com.fiap.ms.usuario.adapters.out.repository.entity.ClienteEntity;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClienteEntityMapper {

    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    ClienteEntity toClienteEntity(ClienteDomain clienteDomain);

    ClienteDomain toClienteDomain(ClienteEntity clienteEntity);

}

