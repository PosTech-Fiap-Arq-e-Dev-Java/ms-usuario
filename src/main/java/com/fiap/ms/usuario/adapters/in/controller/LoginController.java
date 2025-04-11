package com.fiap.ms.usuario.adapters.in.controller;

import com.fiap.ms.usuario.LoginApi;
import com.fiap.ms.usuario.gen.model.LoginDto;
import com.fiap.ms.usuario.gen.model.LoginResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class LoginController implements LoginApi {

    @Override
    public ResponseEntity<LoginResponseDto> _usuariosLoginPost(LoginDto loginDto) {
        return ResponseEntity.ok().build();
    }
}
