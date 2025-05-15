package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.DeletarClienteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarClienteAdapter implements DeletarClienteOutputPort {

    private final ClienteRepository clienteRepository;

    @Override
    public void deletar(UsuarioDomain usuarioDomain) {
        var entity = ClienteEntityMapper.INSTANCE.toClienteEntity(usuarioDomain);
        clienteRepository.delete(entity);
    }
}
