package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.CreateUsuarioUseCase;
import com.fiap.ms.usuario.application.ports.out.CreateUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUsuarioConfig {

    @Bean
    public CreateUsuarioUseCase createUsuarioUseCase(
           CreateUsuarioOutputPort createUsuarioOutputPort
    ){
        return new CreateUsuarioUseCase(createUsuarioOutputPort);
    }
}
