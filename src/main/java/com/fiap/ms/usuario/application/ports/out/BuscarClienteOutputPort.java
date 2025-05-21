package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;

import java.util.Optional;

public interface BuscarClienteOutputPort {

    Optional<UsuarioDomain> buscar(String usuario);
    Optional<UsuarioDomain> buscarPorUsuarioETelefoneEEmail(String usuario, String telefone, String email);
}
