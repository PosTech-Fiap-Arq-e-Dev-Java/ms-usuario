package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.in.InserirClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

    private final InserirClienteOutputPort inserirClienteOutputPort;

    public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort){
        this.inserirClienteOutputPort = inserirClienteOutputPort;
    }

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        inserirClienteOutputPort.inserir(usuarioDomain);
    }
}
