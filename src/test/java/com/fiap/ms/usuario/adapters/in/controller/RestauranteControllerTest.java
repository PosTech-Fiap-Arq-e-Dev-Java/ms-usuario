package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.RestauranteDtoMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.ports.in.*;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarRestauranteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.RestauranteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestauranteControllerTest {

    @Mock
    private InserirRestauranteInputPort inserirRestauranteInputPort;

    @Mock
    private BuscarRestauranteInputPort buscarRestauranteInputPort;

    @Mock
    private DeletarRestauranteInputPort deletarRestauranteInputPort;

    @Mock
    private AtualizarRestauranteInputPort atualizarRestauranteInputPort;

    @Mock
    private RestauranteDtoMapper restauranteDtoMapper;

    @InjectMocks
    private RestauranteController restauranteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarRestauranteComSucesso() {
        String usuario = "restaurante123";

        RestauranteDomain domain = new RestauranteDomain();
        RestauranteDto dto = new RestauranteDto();

        when(buscarRestauranteInputPort.buscar(usuario)).thenReturn(domain);
        when(restauranteDtoMapper.toRestauranteDto(domain)).thenReturn(dto);

        ResponseEntity<RestauranteDto> response = restauranteController._buscarRestaurante(usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dto, response.getBody());

        verify(buscarRestauranteInputPort).buscar(usuario);
        verify(restauranteDtoMapper).toRestauranteDto(domain);
    }

    @Test
    void deveInserirRestauranteComSucesso() {
        RestauranteDto dto = new RestauranteDto();
        RestauranteDomain domain = new RestauranteDomain();

        when(restauranteDtoMapper.toRestauranteDomain(dto)).thenReturn(domain);

        ResponseEntity<Void> response = restauranteController._inserirRestaurante(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNull(response.getBody());

        verify(restauranteDtoMapper).toRestauranteDomain(dto);
        verify(inserirRestauranteInputPort).inserir(domain);
    }

    @Test
    void deveAtualizarRestauranteComSucesso() {
        String usuario = "restaurante123";
        AtualizarRestauranteRequestDto atualizarDto = new AtualizarRestauranteRequestDto();
        RestauranteDomain domain = new RestauranteDomain();

        when(restauranteDtoMapper.toRestauranteDomainUpdate(atualizarDto)).thenReturn(domain);

        ResponseEntity<RestauranteDto> response = restauranteController._atualizarRestaurante(usuario, atualizarDto);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        verify(restauranteDtoMapper).toRestauranteDomainUpdate(atualizarDto);
        verify(atualizarRestauranteInputPort).atualizar(usuario, domain);
    }

    @Test
    void deveDeletarRestauranteComSucesso() {
        String usuario = "restaurante123";

        ResponseEntity<Void> response = restauranteController._deletarRestaurante(usuario);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        verify(deletarRestauranteInputPort).deletar(usuario);
    }
}
