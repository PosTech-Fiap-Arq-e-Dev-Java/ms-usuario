package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.DeletarClienteUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarClienteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClienteConfig {

    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort,
                                                       DeletarClienteOutputPort deletarClienteOutputPort){
        return new DeletarClienteUseCase(buscarClienteOutputPort, deletarClienteOutputPort);
    }
}
