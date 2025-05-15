package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.UsuarioDtoMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.in.AtualizarClienteInputPort;
import com.fiap.ms.usuario.application.ports.in.BuscarClienteInputPort;
import com.fiap.ms.usuario.application.ports.in.DeletarClienteInputPort;
import com.fiap.ms.usuario.application.ports.in.InserirClienteInputPort;
import com.fiap.ms.usuarioDomain.ClienteApi;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarUsuarioRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ClienteController implements ClienteApi {

    private final InserirClienteInputPort inserirClienteInputPort;
    private final BuscarClienteInputPort buscarClienteInputPort;
    private final DeletarClienteInputPort deletarClienteInputPort;
    private final AtualizarClienteInputPort atualizarClienteInputPort;

    public ClienteController(InserirClienteInputPort inserirClienteInputPort,
                             BuscarClienteInputPort buscarClienteInputPort,
                             DeletarClienteInputPort deletarClienteInputPort,
                             AtualizarClienteInputPort atualizarClienteInputPort) {
        this.inserirClienteInputPort = inserirClienteInputPort;
        this.buscarClienteInputPort = buscarClienteInputPort;
        this.deletarClienteInputPort = deletarClienteInputPort;
        this.atualizarClienteInputPort = atualizarClienteInputPort;
    }

    @Override
    public ResponseEntity<UsuarioDto> _buscarCliente(String usuario) {
        UsuarioDomain usuarioDomain = buscarClienteInputPort.buscar(usuario);
        var response = UsuarioDtoMapper.INSTANCE.toUsuarioDto(usuarioDomain);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> _inserirCliente(UsuarioDto usuarioDto) {
        UsuarioDomain usuarioDomain = UsuarioDtoMapper.INSTANCE.toUsuarioDomain(usuarioDto);
        inserirClienteInputPort.inserir(usuarioDomain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<UsuarioDto> _atualizarCliente(String usuario, AtualizarUsuarioRequestDto atualizarUsuarioRequestDtoDto) {
        UsuarioDomain usuarioDomain = UsuarioDtoMapper.INSTANCE.toUsuarioDomainUpdate(atualizarUsuarioRequestDtoDto);
        atualizarClienteInputPort.atualizar(usuario, usuarioDomain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _deletarCliente(String usuario) {
        deletarClienteInputPort.deletar(usuario);
        return ResponseEntity.noContent().build();
    }
}
