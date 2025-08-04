package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;

import java.util.Optional;

public interface BuscarClienteOutputPort {

    Optional<ClienteDomain> buscar(String usuario);
    Optional<ClienteDomain> buscarPorUsuarioOuTelefoneOuEmail(String usuario, String telefone, String email);
}
