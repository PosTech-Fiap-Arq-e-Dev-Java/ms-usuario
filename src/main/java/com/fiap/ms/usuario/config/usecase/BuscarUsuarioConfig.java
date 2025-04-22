package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.BuscarUsuarioUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarUsuarioConfig {

    @Bean
    public BuscarUsuarioUseCase procurarUsuarioUseCase(
           BuscarUsuarioOutputPort buscarUsuarioOutputPort
    ){
        return new BuscarUsuarioUseCase(buscarUsuarioOutputPort);
    }
}
