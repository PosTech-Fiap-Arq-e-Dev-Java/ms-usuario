package com.fiap.ms.usuario.application.ports.in;


import com.fiap.ms.usuario.application.core.domain.ClienteDomain;

public interface InserirClienteInputPort {

    void inserir(ClienteDomain clienteDomain);
}
