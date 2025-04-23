package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.UsuarioDtoMapper;
import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.ports.in.BuscarUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.in.CreateUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.in.DeletarUsuarioInputPort;
import com.fiap.ms.usuario.gen.model.UsuarioDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioDtoMapper usuarioDtoMapper;

    @Mock
    private CreateUsuarioInputPort createUsuarioInputPort;

    @Mock
    private BuscarUsuarioInputPort buscarUsuarioInputPort;

    @Mock
    private DeletarUsuarioInputPort deletarUsuarioInputPort;

    private UsuarioDto usuarioDto;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioDto = new UsuarioDto();
        usuarioDto.setLogin("admin");

        usuario = new Usuario();
        usuario.setLogin("admin");
    }

    @Test
    void testCriaUsuarioComSucesso() {
        when(usuarioDtoMapper.toUsuario(usuarioDto)).thenReturn(usuario);

        ResponseEntity<UsuarioDto> response = usuarioController._usuariosPost(usuarioDto);

        verify(createUsuarioInputPort, times(1)).salvar(usuario);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testBuscaUsuarioPorLoginComSucesso() {
        when(buscarUsuarioInputPort.buscarPorLogin("admin")).thenReturn(usuario);
        when(usuarioDtoMapper.toUsuarioDto(usuario)).thenReturn(usuarioDto);

        ResponseEntity<UsuarioDto> response = usuarioController._usuariosLoginGet("admin");

        verify(buscarUsuarioInputPort, times(1)).buscarPorLogin("admin");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarioDto, response.getBody());
    }

    @Test
    void testBuscaUsuarioLoginNulo() {
        CampoObrigatorioException exception = assertThrows(
                CampoObrigatorioException.class,
                () -> usuarioController._usuariosLoginGet(null)
        );

        assertEquals("login", exception.getMessage());
    }

    @Test
    void testBuscaUsuarioLoginBranco() {
        CampoObrigatorioException exception = assertThrows(
                CampoObrigatorioException.class,
                () -> usuarioController._usuariosLoginGet("   ")
        );

        assertEquals("login", exception.getMessage());
    }

    @Test
    void testDeletarUsuarioComSucesso(){
        ResponseEntity<Void> response = usuarioController._usuariosLoginDelete("admin");

        verify(deletarUsuarioInputPort, times(1)).deletarPorLogin("admin");
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeletarUsuarioLoginNulo(){
        CampoObrigatorioException exception = assertThrows(
                CampoObrigatorioException.class,
                () -> usuarioController._usuariosLoginGet(null)
        );

        assertEquals("login", exception.getMessage());
    }

    @Test
    void testDeletarUsuarioLoginBranco(){
        CampoObrigatorioException exception = assertThrows(
                CampoObrigatorioException.class,
                () -> usuarioController._usuariosLoginDelete("    ")
        );
    }
}
