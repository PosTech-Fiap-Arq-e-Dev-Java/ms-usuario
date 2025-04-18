package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.UsuarioRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.ports.out.CreateUsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUsuarioAdapter implements CreateUsuarioOutputPort {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public void salvar(Usuario usuario) {
        var usuarioEntity = usuarioEntityMapper.toUsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }
}
