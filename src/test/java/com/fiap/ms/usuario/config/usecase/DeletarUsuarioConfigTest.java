//package com.fiap.ms.usuario.config.usecase;
//
//import com.fiap.ms.usuario.application.core.usecase.DeletarUsuarioUseCase;
//import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
//import com.fiap.ms.usuario.application.ports.out.DeletarUsuarioOutputPort;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.runner.ApplicationContextRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.mock;
//
//class DeletarUsuarioConfigTest {
//
//    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
//            .withUserConfiguration(TestConfig.class);
//
//    @Test
//    void testDeletarUsuarioUseCaseBeanIsCreated() {
//        contextRunner.run(context -> {
//            DeletarUsuarioUseCase useCase = context.getBean(DeletarUsuarioUseCase.class);
//            assertThat(useCase).isNotNull();
//        });
//    }
//
//    @Configuration
//    static class TestConfig {
//
//        @Bean
//        public BuscarUsuarioOutputPort buscarUsuarioOutputPort() {
//            return mock(BuscarUsuarioOutputPort.class);
//        }
//
//        @Bean
//        public DeletarUsuarioOutputPort deletarUsuarioOutputPort() {
//            return mock(DeletarUsuarioOutputPort.class);
//        }
//
//        @Bean
//        public DeletarUsuarioConfig deletarUsuarioConfig() {
//            return new DeletarUsuarioConfig();
//        }
//
//        @Bean
//        public DeletarUsuarioUseCase deletarUsuarioUseCase() {
//            return deletarUsuarioConfig().deletarUsuarioUseCase(
//                    buscarUsuarioOutputPort(), deletarUsuarioOutputPort());
//        }
//    }
//}
