package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.UsuarioRepository;
import com.fiap.ms.usuario.application.ports.out.DeletarUsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarUsuarioAdapter implements DeletarUsuarioOutputPort {

    private final UsuarioRepository repository;

    @Autowired
    public DeletarUsuarioAdapter(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}

