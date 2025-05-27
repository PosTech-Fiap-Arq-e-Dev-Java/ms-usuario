package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import com.fiap.ms.usuario.application.core.AtualizarRestauranteUseCase;
import com.fiap.ms.usuario.application.ports.out.AtualizarRestauranteOutputPort;
import com.fiap.ms.usuario.application.ports.out.BuscarRestauranteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarRestauranteConfig {

    @Bean
    public AtualizarRestauranteUseCase atualizarRestauranteUseCase(BuscarRestauranteOutputPort buscarRestauranteOutputPort,
                                                                   AtualizarRestauranteOutputPort atualizarRestauranteUseCase,
                                                                   UsuarioValidatorHandler usuarioValidatorHandler) {
        return new AtualizarRestauranteUseCase(buscarRestauranteOutputPort, atualizarRestauranteUseCase, usuarioValidatorHandler);
    }
}
