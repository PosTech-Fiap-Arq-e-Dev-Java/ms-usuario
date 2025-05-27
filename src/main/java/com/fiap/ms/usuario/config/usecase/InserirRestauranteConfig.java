package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import com.fiap.ms.usuario.application.core.InserirRestauranteUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirRestauranteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirRestauranteConfig {

    @Bean
    public InserirRestauranteUseCase inserirRestauranteUseCase(InserirRestauranteOutputPort inserirRestauranteOutputPort,
                                                               BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                                               UsuarioValidatorHandler usuarioValidatorHandler){
        return new InserirRestauranteUseCase(inserirRestauranteOutputPort, buscarRestauranteOutputPort, usuarioValidatorHandler);
    }
}
