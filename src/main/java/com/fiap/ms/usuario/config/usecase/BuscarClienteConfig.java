package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.BuscarClienteUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClienteConfig {

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort){
        return new BuscarClienteUseCase(buscarClienteOutputPort);
    }
}
