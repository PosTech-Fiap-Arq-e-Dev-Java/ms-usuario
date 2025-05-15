package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.UsuarioDtoMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.in.BuscarRestauranteInputPort;
import com.fiap.ms.usuario.application.ports.in.DeletarRestauranteInputPort;
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
    private final BuscarRestauranteInputPort buscarRestauranteInputPort;
    private final DeletarRestauranteInputPort deletarRestauranteInputPort;

    public RestauranteController(InserirRestauranteInputPort inserirRestauranteInputPort,
                                 BuscarRestauranteInputPort buscarRestauranteInputPort,
                                 DeletarRestauranteInputPort deletarRestauranteInputPort) {
        this.inserirRestauranteInputPort = inserirRestauranteInputPort;
        this.buscarRestauranteInputPort = buscarRestauranteInputPort;
        this.deletarRestauranteInputPort = deletarRestauranteInputPort;
    }

    @Override
    public ResponseEntity<UsuarioDto> _buscarRestaurante(String usuario) {
        UsuarioDomain usuarioDomain = buscarRestauranteInputPort.buscar(usuario);
        var response = UsuarioDtoMapper.INSTANCE.toUsuarioDto(usuarioDomain);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> _inserirRestaurante(UsuarioDto usuarioDto) {
        UsuarioDomain usuarioDomain = UsuarioDtoMapper.INSTANCE.toUsuarioDomain(usuarioDto);
        inserirRestauranteInputPort.inserir(usuarioDomain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> _deletarRestaurante(String usuario) {
        deletarRestauranteInputPort.deletar(usuario);
        return ResponseEntity.noContent().build();
    }

}
