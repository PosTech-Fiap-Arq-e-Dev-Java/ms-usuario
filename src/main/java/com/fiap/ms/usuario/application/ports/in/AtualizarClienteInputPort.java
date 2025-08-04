package com.fiap.ms.usuario.application.ports.in;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;

public interface AtualizarClienteInputPort {

    void atualizar(String usuario, ClienteDomain clienteDomain);
}
