package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.CreateUsuarioUseCase;
import com.fiap.ms.usuario.application.core.usecase.ProcurarUsuarioUseCase;
import com.fiap.ms.usuario.application.ports.out.CreateUsuarioOutputPort;
import com.fiap.ms.usuario.application.ports.out.ProcurarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcurarUsuarioConfig {

    @Bean
    public ProcurarUsuarioUseCase procurarUsuarioUseCase(
           ProcurarUsuarioOutputPort procurarUsuarioOutputPort
    ){
        return new ProcurarUsuarioUseCase(procurarUsuarioOutputPort);
    }
}
