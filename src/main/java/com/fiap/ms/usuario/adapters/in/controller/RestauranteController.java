package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.RestauranteDtoMapper;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.ports.in.AtualizarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.in.BuscarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.in.DeletarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.in.InserirRestauranteInputPort;
import com.fiap.ms.usuarioDomain.RestauranteApi;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarRestauranteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.RestauranteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RestauranteController implements RestauranteApi {

    private final InserirRestauranteInputPort inserirRestauranteInputPort;
    private final BuscarRestauranteInputPort buscarRestauranteInputPort;
    private final DeletarRestauranteInputPort deletarRestauranteInputPort;
    private final AtualizarRestauranteInputPort atualizarRestauranteInputPort;
    private final RestauranteDtoMapper restauranteDtoMapper;

    public RestauranteController(InserirRestauranteInputPort inserirRestauranteInputPort,
                                 BuscarRestauranteInputPort buscarRestauranteInputPort,
                                 DeletarRestauranteInputPort deletarRestauranteInputPort,
                                 AtualizarRestauranteInputPort atualizarRestauranteInputPort,
                                 RestauranteDtoMapper restauranteDtoMapper) {
        this.inserirRestauranteInputPort = inserirRestauranteInputPort;
        this.buscarRestauranteInputPort = buscarRestauranteInputPort;
        this.deletarRestauranteInputPort = deletarRestauranteInputPort;
        this.atualizarRestauranteInputPort = atualizarRestauranteInputPort;
        this.restauranteDtoMapper = restauranteDtoMapper;
    }

    @Override
    public ResponseEntity<RestauranteDto> _buscarRestaurante(String usuario) {
        RestauranteDomain restauranteDomain = buscarRestauranteInputPort.buscar(usuario);
        RestauranteDto response = restauranteDtoMapper.toRestauranteDto(restauranteDomain);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> _inserirRestaurante(RestauranteDto restauranteDto) {
        RestauranteDomain restauranteDomain = restauranteDtoMapper.toRestauranteDomain(restauranteDto);
        inserirRestauranteInputPort.inserir(restauranteDomain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<RestauranteDto> _atualizarRestaurante(String usuario, AtualizarRestauranteRequestDto atualizarRestauranteRequestDto) {
        RestauranteDomain restauranteDomain = restauranteDtoMapper.toRestauranteDomainUpdate(atualizarRestauranteRequestDto);
        atualizarRestauranteInputPort.atualizar(usuario, restauranteDomain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _deletarRestaurante(String usuario) {
        deletarRestauranteInputPort.deletar(usuario);
        return ResponseEntity.noContent().build();
    }
}

