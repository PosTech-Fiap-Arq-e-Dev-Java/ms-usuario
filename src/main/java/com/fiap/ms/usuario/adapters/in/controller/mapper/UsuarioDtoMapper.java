package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.gen.model.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioDtoMapper {

    @Mapping(target = "dataAlteracao", source = "dataAlteracao")
    @Mapping(target = "dataCriacao", source = "dataCriacao")
    @Mapping(target = "dataExclusao", source = "dataExclusao")
    @Mapping(target = "id", ignore = true)
    Usuario toUsuario(UsuarioDto usuarioDto);

    @Mapping(target = "dataAlteracao", source = "dataAlteracao")
    @Mapping(target = "dataCriacao", source = "dataCriacao")
    @Mapping(target = "dataExclusao", source = "dataExclusao")
    UsuarioDto toUsuarioDto(Usuario usuarioDto);

    UsuarioDtoMapper INSTANCE = Mappers.getMapper(UsuarioDtoMapper.class);

    default OffsetDateTime convertDateToOffsetDateTime(String value) {
        if (value == null) return null;
        LocalDateTime localDateTime = LocalDateTime.parse(value);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/Sao_Paulo"));
        return zonedDateTime.toOffsetDateTime();
    }

    default LocalDateTime map(OffsetDateTime value) {
        return value == null ? null : value.toLocalDateTime();
    }
}
