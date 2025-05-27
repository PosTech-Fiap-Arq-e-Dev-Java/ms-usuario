package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import com.fiap.ms.usuario.application.core.InserirClienteUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirClienteConfig {

    @Bean
    public InserirClienteUseCase inserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort,
                                                       BuscarClienteOutputPort buscarClienteOutputPort,
                                                       UsuarioValidatorHandler usuarioValidatorHandler){
        return new InserirClienteUseCase(inserirClienteOutputPort, buscarClienteOutputPort, usuarioValidatorHandler);
    }
}
