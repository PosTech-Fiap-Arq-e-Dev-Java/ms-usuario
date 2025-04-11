package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.UsuarioApi;
import com.fiap.ms.usuario.gen.model.LoginDto;
import com.fiap.ms.usuario.gen.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UsuarioController implements UsuarioApi {

    @Override
    public ResponseEntity<Void> _usuariosLoginDelete(String login) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UsuarioDto> _usuariosLoginGet(String login) {
        return ResponseEntity.ok().build();
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
        return ResponseEntity.ok().build();
    }
}
