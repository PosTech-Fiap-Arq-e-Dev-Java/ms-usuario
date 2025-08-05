package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.RestauranteRepository;
import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarRestauranteAdapterTest {

    private RestauranteRepository restauranteRepository;
    private RestauranteEntityMapper restauranteEntityMapper;
    private BuscarRestauranteAdapter buscarRestauranteAdapter;

    @BeforeEach
    void setUp() {
        restauranteRepository = mock(RestauranteRepository.class);
        restauranteEntityMapper = mock(RestauranteEntityMapper.class);
        buscarRestauranteAdapter = new BuscarRestauranteAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Test
    void deveRetornarRestauranteDomain_quandoBuscarPorUsuarioExistente() {
        // Arrange
        String usuario = "restaurante123";
        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(1L);
        entity.setUsuario(usuario);
        entity.setNome("Restaurante Teste");

        RestauranteDomain domain = new RestauranteDomain();
        domain.setId(1L);
        domain.setUsuario(usuario);
        domain.setNome("Restaurante Teste");

        when(restauranteRepository.findByUsuario(usuario)).thenReturn(Optional.of(entity));
        when(restauranteEntityMapper.toRestauranteDomain(entity)).thenReturn(domain);

        Optional<RestauranteDomain> resultado = buscarRestauranteAdapter.buscar(usuario);

        assertTrue(resultado.isPresent());
        assertEquals(domain.getId(), resultado.get().getId());
        assertEquals(domain.getUsuario(), resultado.get().getUsuario());
    }

    @Test
    void deveRetornarVazio_quandoBuscarPorUsuarioInexistente() {
        when(restauranteRepository.findByUsuario("inexistente")).thenReturn(Optional.empty());

        Optional<RestauranteDomain> resultado = buscarRestauranteAdapter.buscar("inexistente");

        assertTrue(resultado.isEmpty());
        verify(restauranteEntityMapper, never()).toRestauranteDomain(any());
    }

    @Test
    void deveRetornarRestauranteDomain_quandoBuscarPorUsuarioOuTelefoneOuEmail() {
        String usuario = "restaurante123";
        String telefone = "11999999999";
        String email = "rest@teste.com";

        RestauranteEntity entity = new RestauranteEntity();
        entity.setUsuario(usuario);
        entity.setTelefone(telefone);
        entity.setEmail(email);

        RestauranteDomain domain = new RestauranteDomain();
        domain.setUsuario(usuario);
        domain.setTelefone(telefone);
        domain.setEmail(email);

        when(restauranteRepository.findByUsuarioOrTelefoneOrEmail(usuario, telefone, email))
                .thenReturn(Optional.of(entity));
        when(restauranteEntityMapper.toRestauranteDomain(entity)).thenReturn(domain);

        Optional<RestauranteDomain> resultado =
                buscarRestauranteAdapter.buscarPorUsuarioOuTelefoneOuEmail(usuario, telefone, email);

        assertTrue(resultado.isPresent());
        assertEquals(usuario, resultado.get().getUsuario());
        assertEquals(telefone, resultado.get().getTelefone());
        assertEquals(email, resultado.get().getEmail());
    }

    @Test
    void deveRetornarVazio_quandoBuscarPorUsuarioTelefoneEmailInexistentes() {
        when(restauranteRepository.findByUsuarioOrTelefoneOrEmail("nao", "existe", "aqui"))
                .thenReturn(Optional.empty());

        Optional<RestauranteDomain> resultado =
                buscarRestauranteAdapter.buscarPorUsuarioOuTelefoneOuEmail("nao", "existe", "aqui");

        assertTrue(resultado.isEmpty());
        verify(restauranteEntityMapper, never()).toRestauranteDomain(any());
    }
}

