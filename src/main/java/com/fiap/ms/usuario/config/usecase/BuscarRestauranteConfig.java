package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.BuscarRestauranteUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestauranteConfig {

    @Bean
    public BuscarRestauranteUseCase buscarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort){
        return new BuscarRestauranteUseCase(buscarRestauranteOutputPort);
    }
}
