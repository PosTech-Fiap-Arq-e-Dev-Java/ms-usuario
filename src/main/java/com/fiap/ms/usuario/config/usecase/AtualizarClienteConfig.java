package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.AtualizarClienteUseCase;
import com.fiap.ms.usuario.application.ports.out.AtualizarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarClienteConfig {

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort,
                                                           AtualizarClienteOutputPort atualizarClienteOutputPort) {
        return new AtualizarClienteUseCase(buscarClienteOutputPort, atualizarClienteOutputPort);
    }
}
