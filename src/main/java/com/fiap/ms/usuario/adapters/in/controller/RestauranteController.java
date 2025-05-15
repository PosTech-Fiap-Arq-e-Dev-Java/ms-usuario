package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.UsuarioDtoMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.in.InserirRestauranteInputPort;
import com.fiap.ms.usuarioDomain.RestauranteApi;
import com.fiap.ms.usuarioDomain.gen.model.UsuarioDto;
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

    public RestauranteController(InserirRestauranteInputPort inserirRestauranteInputPort) {
        this.inserirRestauranteInputPort = inserirRestauranteInputPort;
    }

    @Override
    public ResponseEntity<Void> _inserirRestaurante(UsuarioDto usuarioDto) {
        UsuarioDomain usuarioDomain = UsuarioDtoMapper.INSTANCE.toUsuarioDomain(usuarioDto);
        inserirRestauranteInputPort.inserir(usuarioDomain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
