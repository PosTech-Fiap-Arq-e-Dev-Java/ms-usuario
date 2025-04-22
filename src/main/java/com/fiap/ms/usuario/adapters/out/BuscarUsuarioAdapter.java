package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.UsuarioRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioAdapter implements BuscarUsuarioOutputPort {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public Usuario buscarPorLogin(String login) {
        var usuarioEntity = repository.findByLogin(login);
        return usuarioEntityMapper.toUsuario(usuarioEntity);
    }
}
