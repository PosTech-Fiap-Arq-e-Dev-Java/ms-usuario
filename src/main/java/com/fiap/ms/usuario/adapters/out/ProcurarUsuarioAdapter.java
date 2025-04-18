package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.UsuarioRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.ports.out.ProcurarUsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcurarUsuarioAdapter implements ProcurarUsuarioOutputPort {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public Usuario buscar(String admin) {
        var usuarioEntity = repository.findByLogin(admin);
        return usuarioEntityMapper.toUsuario(usuarioEntity);
    }
}
