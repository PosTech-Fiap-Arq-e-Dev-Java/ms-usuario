package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.DeletarUsuarioUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.usuario.application.ports.out.DeletarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarUsuarioConfig {

    @Bean
    public DeletarUsuarioUseCase deletarUsuarioUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                                                       DeletarUsuarioOutputPort deletarUsuarioOutputPort)
    {
        return new DeletarUsuarioUseCase(buscarUsuarioOutputPort, deletarUsuarioOutputPort);
    }
}
