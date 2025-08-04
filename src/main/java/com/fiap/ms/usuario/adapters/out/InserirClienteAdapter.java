package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InserirClienteAdapter implements InserirClienteOutputPort {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public void inserir(ClienteDomain clienteDomain) {
        var usuarioEntity = ClienteEntityMapper.INSTANCE.toClienteEntity(clienteDomain);
        clienteRepository.save(usuarioEntity);
    }
}
