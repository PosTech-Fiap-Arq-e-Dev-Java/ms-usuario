package com.fiap.ms.usuario.common.config;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

public class MockUsuario {

    public static UsuarioDomain getUsuarioDomain() {
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setId(1L);
        usuarioDomain.setUsuario("admin123");
        usuarioDomain.setNome("Ronaldo Nazario");
        usuarioDomain.setEmail("Ronaldo@fenomeno.com");
        usuarioDomain.setEndereco("Rua Paulista, 1000");
        usuarioDomain.setTelefone("+55 11 99999-9999");
        return usuarioDomain;
    }

    public static UsuarioDomain getUsuarioDomainAtualizado() {
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setId(1L);
        usuarioDomain.setUsuario("admin123");
        usuarioDomain.setNome("Ronaldo Nazario");
        usuarioDomain.setEmail("neymar@brasil.com");
        usuarioDomain.setEndereco("Rua baixada, 100");
        usuarioDomain.setTelefone("+55 11 98888-8888");
        return usuarioDomain;
    }

}
