package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.UsuarioApi;
import com.fiap.ms.usuario.adapters.in.controller.mapper.UsuarioDtoMapper;
import com.fiap.ms.usuario.application.ports.in.CreateUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.in.BuscarUsuarioInputPort;
import com.fiap.ms.usuario.gen.model.LoginDto;
import com.fiap.ms.usuario.gen.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UsuarioController implements UsuarioApi {

    @Autowired
    private UsuarioDtoMapper usuarioDtoMapper;

    @Autowired
    private CreateUsuarioInputPort createUsuarioInputPort;

    @Autowired
    private BuscarUsuarioInputPort buscarUsuarioInputPort;

    @Override
    public ResponseEntity<Void> _usuariosLoginDelete(String login) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UsuarioDto> _usuariosLoginGet(String login) {
        var usuario = buscarUsuarioInputPort.buscar(login);
        var usuarioDto = usuarioDtoMapper.toUsuarioDto(usuario);
        return ResponseEntity.ok().body(usuarioDto);
    }

    @Override
    public ResponseEntity<UsuarioDto> _usuariosLoginPut(String login, UsuarioDto usuarioDto) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _usuariosLoginSenhaPatch(String login, LoginDto loginDto) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UsuarioDto> _usuariosPost(UsuarioDto usuarioDto) {
        var usuario = usuarioDtoMapper.toUsuario(usuarioDto);
        createUsuarioInputPort.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
