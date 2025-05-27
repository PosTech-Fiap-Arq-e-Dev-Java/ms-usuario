package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.DeletarRestauranteUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarRestauranteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarRestauranteConfig {

    @Bean
    public DeletarRestauranteUseCase deletarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                                               DeletarRestauranteOutputPort deletarRestauranteOutputPort){
        return new DeletarRestauranteUseCase(buscarRestauranteOutputPort, deletarRestauranteOutputPort);
    }
}
