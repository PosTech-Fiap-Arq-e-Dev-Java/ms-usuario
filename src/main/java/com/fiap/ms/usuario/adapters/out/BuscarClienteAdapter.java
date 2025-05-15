package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarClienteAdapter implements BuscarClienteOutputPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Optional<UsuarioDomain> buscar(String usuario) {
        return clienteRepository.findByUsuario(usuario)
                .map(ClienteEntityMapper.INSTANCE::toUsuarioDomain);
    }
}
