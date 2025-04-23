package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.gen.model.UsuarioDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDtoMapperTest {

    private final UsuarioDtoMapper mapper = UsuarioDtoMapper.INSTANCE;

    @Test
    void testToUsuario() {
        UsuarioDto dto = new UsuarioDto();
        dto.setLogin("admin");
        dto.setEmail("admin@email.com");

        Usuario usuario = mapper.toUsuario(dto);

        assertEquals(dto.getLogin(), usuario.getLogin());
        assertEquals(dto.getEmail(), usuario.getEmail());
    }

    @Test
    void testToUsuarioDto() {
        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setEmail("admin@email.com");
        usuario.setDataCriacao(LocalDateTime.now());

        UsuarioDto dto = mapper.toUsuarioDto(usuario);

        assertEquals(usuario.getLogin(), dto.getLogin());
        assertEquals(usuario.getEmail(), dto.getEmail());
        assertNotNull(dto.getDataCriacao());
    }

    @Test
    void testMap_OffsetDateTimeToLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        assertEquals(now, mapper.map(now.atOffset(java.time.ZoneOffset.ofHours(-3))));
    }
}
