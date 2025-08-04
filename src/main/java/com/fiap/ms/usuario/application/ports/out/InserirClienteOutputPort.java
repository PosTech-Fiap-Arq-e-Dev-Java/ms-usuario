package com.fiap.ms.usuario.application.ports.out;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;

public interface InserirClienteOutputPort {

    void inserir(ClienteDomain clienteDomain);
}
