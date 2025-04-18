package com.fiap.ms.usuario.adapters.out.repository.mapper;

import com.fiap.ms.usuario.adapters.out.repository.entity.TipoUsuarioEntity;
import com.fiap.ms.usuario.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.core.domain.enums.TipoUsuarioEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Arrays;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioEntityMapper {

    @Mapping(source = "tipoUsuario", target = "tipoUsuario")
    UsuarioEntity toUsuarioEntity(Usuario usuario);

    @Mapping(source = "tipoUsuario", target = "tipoUsuario")
    Usuario toUsuario(UsuarioEntity usuarioEntity);

    default TipoUsuarioEntity map(TipoUsuarioEnum tipoUsuarioEnum) {
        if (tipoUsuarioEnum == null) return null;

        TipoUsuarioEntity entity = new TipoUsuarioEntity();
        entity.setId((long) tipoUsuarioEnum.getId());
        entity.setDescricao(tipoUsuarioEnum.getDescricao());
        return entity;
    }

    default TipoUsuarioEnum map(TipoUsuarioEntity tipoUsuarioEntity) {
        if (tipoUsuarioEntity == null) {
            return null;
        }

        return Arrays.stream(TipoUsuarioEnum.values())
                .filter(e -> e.getId() == tipoUsuarioEntity.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("TipoUsuarioEntity inválido: " + tipoUsuarioEntity.getId()));
    }
}
