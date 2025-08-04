package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.AtualizarClienteUseCase;
import com.fiap.ms.usuario.application.core.handler.ClienteValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.AtualizarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarClienteConfig {

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort,
                                                           AtualizarClienteOutputPort atualizarClienteOutputPort,
                                                           ClienteValidatorHandler usuarioValidatorHandler) {
        return new AtualizarClienteUseCase(buscarClienteOutputPort, atualizarClienteOutputPort, usuarioValidatorHandler);
    }
}
