package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

import java.util.Optional;

public interface BuscarRestauranteOutputPort {

    Optional<UsuarioDomain> buscar(String usuario);
    Optional<UsuarioDomain> buscarPorUsuarioOuTelefoneOuEmail(String usuario, String telefone, String email);
}
