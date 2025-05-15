package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarUsuarioRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioDtoMapper {

    UsuarioDtoMapper INSTANCE = Mappers.getMapper(UsuarioDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    UsuarioDomain toUsuarioDomain(UsuarioDto usuarioDto);

    UsuarioDto toUsuarioDto(UsuarioDomain usuarioDomainDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    UsuarioDomain toUsuarioDomainUpdate(AtualizarUsuarioRequestDto atualizarUsuarioRequestDto);

}
