package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.in.InserirRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;

public class InserirRestauranteUseCase implements InserirRestauranteInputPort {

    private final InserirRestauranteOutputPort inserirRestauranteOutputPort;

    public InserirRestauranteUseCase(InserirRestauranteOutputPort inserirRestauranteOutputPort){
        this.inserirRestauranteOutputPort = inserirRestauranteOutputPort;
    }

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        inserirRestauranteOutputPort.inserir(usuarioDomain);
    }
}
