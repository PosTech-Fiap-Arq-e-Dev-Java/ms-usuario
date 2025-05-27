package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BuscarRestauranteAdapterTest {

    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private BuscarRestauranteAdapter buscarClienteAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarUsuarioComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        when(repository.findByUsuario(usuarioDomain.getUsuario())).thenReturn(Optional.of(restauranteEntity));

        Optional<UsuarioDomain> result = buscarClienteAdapter.buscar(usuarioDomain.getUsuario());

        assertTrue(result.isPresent());
        verify(repository).findByUsuario(usuarioDomain.getUsuario());
        verify(repository, times(1)).findByUsuario(usuarioDomain.getUsuario());
    }

    @Test
    void deveRetornarVazioQuandoNaoEncontrarUsuario() {
        String usuario = "user123";

        when(repository.findByUsuario(usuario)).thenReturn(Optional.empty());

        Optional<UsuarioDomain> result = buscarClienteAdapter.buscar(usuario);

        assertTrue(result.isEmpty());
        verify(repository).findByUsuario(usuario);
    }

    @Test
    void deveBuscarOuTelefoneOuEmailComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        RestauranteEntity restauranteEntity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(usuarioDomain);

        when(repository.findByUsuarioOrTelefoneOrEmail(usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail()))
                .thenReturn(Optional.of(restauranteEntity));

        Optional<UsuarioDomain> result = buscarClienteAdapter
                .buscarPorUsuarioOuTelefoneOuEmail(usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail());

        assertTrue(result.isPresent());
        verify(repository).findByUsuarioOrTelefoneOrEmail(usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail());
        verify(repository, times(1))
                .findByUsuarioOrTelefoneOrEmail(usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail());
    }

    @Test
    void deveRetornarVazioQuandoNaoEncontrarBuscarOuTelefoneOuEmail() {
        String usuario = "user123";
        String email = "neymar@brasil.com";
        String telefone = "11999999999";

        when(repository.findByUsuarioOrTelefoneOrEmail(usuario, telefone, email)).thenReturn(Optional.empty());

        Optional<UsuarioDomain> result = buscarClienteAdapter.buscarPorUsuarioOuTelefoneOuEmail(usuario, telefone, email);

        assertTrue(result.isEmpty());
        verify(repository).findByUsuarioOrTelefoneOrEmail(usuario, telefone, email);
    }


}
