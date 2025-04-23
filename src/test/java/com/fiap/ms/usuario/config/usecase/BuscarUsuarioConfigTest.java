package com.fiap.ms.usuario.config.usecase;

import com.fiap.ms.usuario.application.core.usecase.BuscarUsuarioUseCase;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class BuscarUsuarioConfigTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(TestConfig.class);

    @Test
    void testBuscarUsuarioUseCaseBeanIsCreated() {
        contextRunner.run(context -> {
            BuscarUsuarioUseCase useCase = context.getBean(BuscarUsuarioUseCase.class);
            assertThat(useCase).isNotNull();
        });
    }

    @Configuration
    static class TestConfig {

        @Bean
        public BuscarUsuarioOutputPort buscarUsuarioOutputPort() {
            return mock(BuscarUsuarioOutputPort.class);
        }

        @Bean
        public BuscarUsuarioConfig buscarUsuarioConfig() {
            return new BuscarUsuarioConfig();
        }

        @Bean
        public BuscarUsuarioUseCase buscarUsuarioUseCase() {
            return buscarUsuarioConfig().procurarUsuarioUseCase(buscarUsuarioOutputPort());
        }
    }
}
