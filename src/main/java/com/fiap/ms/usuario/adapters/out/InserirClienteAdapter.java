package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirClienteAdapter implements InserirClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void inserir(UsuarioDomain usuarioDomain) {
        var usuarioEntity = ClienteEntityMapper.INSTANCE.toClienteEntity(usuarioDomain);
        clienteRepository.save(usuarioEntity);
    }
}
