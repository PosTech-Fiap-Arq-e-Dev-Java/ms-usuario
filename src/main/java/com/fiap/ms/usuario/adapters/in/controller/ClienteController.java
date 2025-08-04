package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.adapters.in.controller.mapper.ClienteDtoMapper;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.ports.in.AtualizarClienteInputPort;
import com.fiap.ms.usuario.application.ports.in.BuscarClienteInputPort;
import com.fiap.ms.usuario.application.ports.in.DeletarClienteInputPort;
import com.fiap.ms.usuario.application.ports.in.InserirClienteInputPort;
import com.fiap.ms.usuarioDomain.ClienteApi;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarClienteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.ClienteDto;
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
    private final ClienteDtoMapper clienteDtoMapper;

    public ClienteController(InserirClienteInputPort inserirClienteInputPort,
                             BuscarClienteInputPort buscarClienteInputPort,
                             DeletarClienteInputPort deletarClienteInputPort,
                             AtualizarClienteInputPort atualizarClienteInputPort,
                             ClienteDtoMapper clienteDtoMapper) {
        this.inserirClienteInputPort = inserirClienteInputPort;
        this.buscarClienteInputPort = buscarClienteInputPort;
        this.deletarClienteInputPort = deletarClienteInputPort;
        this.atualizarClienteInputPort = atualizarClienteInputPort;
        this.clienteDtoMapper = clienteDtoMapper;
    }

    @Override
    public ResponseEntity<ClienteDto> _buscarCliente(String usuario) {
        ClienteDomain clienteDomain = buscarClienteInputPort.buscar(usuario);
        ClienteDto response = clienteDtoMapper.toClienteDto(clienteDomain);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> _inserirCliente(ClienteDto clienteDto) {
        ClienteDomain clienteDomain = clienteDtoMapper.toClienteDomain(clienteDto);
        inserirClienteInputPort.inserir(clienteDomain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<ClienteDto> _atualizarCliente(String usuario, AtualizarClienteRequestDto atualizarClienteRequestDto) {
        ClienteDomain clienteDomain = clienteDtoMapper.toClienteDomainUpdate(atualizarClienteRequestDto);
        atualizarClienteInputPort.atualizar(usuario, clienteDomain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _deletarCliente(String usuario) {
        deletarClienteInputPort.deletar(usuario);
        return ResponseEntity.noContent().build();
    }
}

