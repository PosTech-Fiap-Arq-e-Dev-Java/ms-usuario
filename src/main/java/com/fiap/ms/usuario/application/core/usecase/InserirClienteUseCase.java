package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.ports.in.InserirClienteInputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

    private final InserirClienteOutputPort inserirClienteOutputPort;
    private final BuscarClienteOutputPort buscarClienteOutputPort;

    public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort,
                                 BuscarClienteOutputPort buscarClienteOutputPort){
        this.inserirClienteOutputPort = inserirClienteOutputPort;
        this.buscarClienteOutputPort = buscarClienteOutputPort;
    }

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        buscarClienteOutputPort.buscarPorUsuarioETelefoneEEmail(
                usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail())
                .ifPresent(cliente -> {
                    throw new UsuarioJaExistenteException();
                });

        inserirClienteOutputPort.inserir(usuarioDomain);
    }
}
