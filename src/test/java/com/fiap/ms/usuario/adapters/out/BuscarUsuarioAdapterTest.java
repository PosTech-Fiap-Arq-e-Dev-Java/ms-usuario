package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.UsuarioRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.ms.usuario.application.core.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BuscarUsuarioAdapterTest {

    @InjectMocks
    private BuscarUsuarioAdapter buscarUsuarioAdapter;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private UsuarioEntityMapper usuarioEntityMapper;

    private UsuarioEntity usuarioEntity;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        usuarioEntity = new UsuarioEntity();
        usuarioEntity.setLogin("admin");

        usuario = new Usuario();
        usuario.setLogin("admin");
    }

    @Test
    void testBuscaPorLogin() {
        when(repository.findByLogin("admin")).thenReturn(usuarioEntity);
        when(usuarioEntityMapper.toUsuario(usuarioEntity)).thenReturn(usuario);

        Usuario result = buscarUsuarioAdapter.buscarPorLogin("admin");

        verify(repository, times(1)).findByLogin("admin");
        verify(usuarioEntityMapper, times(1)).toUsuario(usuarioEntity);
        assertEquals("admin", result.getLogin());
    }
}

