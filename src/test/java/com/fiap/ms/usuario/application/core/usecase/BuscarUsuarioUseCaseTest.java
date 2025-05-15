//package com.fiap.ms.usuario.application.core.usecase;
//
//import com.fiap.ms.usuario.application.core.domain.Usuario;
//import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
//import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class BuscarUsuarioUseCaseTest {
//
//    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
//    private BuscarUsuarioUseCase buscarUsuarioUseCase;
//
//    @BeforeEach
//    void setUp() {
//        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
//        buscarUsuarioUseCase = new BuscarUsuarioUseCase(buscarUsuarioOutputPort);
//    }
//
//    @Test
//    void testarUsuarioExistente() {
//        String login = "admin";
//        Usuario usuario = new Usuario();
//        usuario.setLogin(login);
//
//        when(buscarUsuarioOutputPort.buscarPorLogin(login)).thenReturn(usuario);
//
//        Usuario resultado = buscarUsuarioUseCase.buscarPorLogin(login);
//
//        assertNotNull(resultado);
//        assertEquals(login, resultado.getLogin());
//        verify(buscarUsuarioOutputPort, times(1)).buscarPorLogin(login);
//    }
//
//    @Test
//    void testUsuarioInexistente() {
//        String login = "inexistente";
//        when(buscarUsuarioOutputPort.buscarPorLogin(login)).thenReturn(null);
//
//        UsuarioNaoEncontradoException exception = assertThrows(
//                UsuarioNaoEncontradoException.class,
//                () -> buscarUsuarioUseCase.buscarPorLogin(login)
//        );
//
//        assertEquals("Usuário com login 'inexistente' não encontrado.", exception.getMessage());
//        verify(buscarUsuarioOutputPort, times(1)).buscarPorLogin(login);
//    }
//}
//
