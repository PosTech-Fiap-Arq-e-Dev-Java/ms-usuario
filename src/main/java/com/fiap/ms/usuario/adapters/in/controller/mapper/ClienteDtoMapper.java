package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarClienteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClienteDtoMapper {

    @Mapping(target = "id", ignore = true)
    ClienteDomain toClienteDomain(ClienteDto clienteDto);

    ClienteDto toClienteDto(ClienteDomain clienteDomain);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    ClienteDomain toClienteDomainUpdate(AtualizarClienteRequestDto atualizarDto);
}
