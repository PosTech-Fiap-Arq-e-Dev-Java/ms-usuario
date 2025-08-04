package com.fiap.ms.usuario.adapters.out;

import com.fiap.ms.usuario.adapters.out.repository.ClienteRepository;
import com.fiap.ms.usuario.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarClienteAdapter implements BuscarClienteOutputPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Optional<ClienteDomain> buscar(String usuario) {
        var clienteEntity = clienteRepository.findByUsuario(usuario);
        return clienteEntity.map(ClienteEntityMapper.INSTANCE::toClienteDomain);
    }

    @Override
    public Optional<ClienteDomain> buscarPorUsuarioOuTelefoneOuEmail(String usuario, String telefone, String email) {
        var clienteEntity = clienteRepository.findByUsuarioOrTelefoneOrEmail(usuario, telefone, email);
        return clienteEntity.map(ClienteEntityMapper.INSTANCE::toClienteDomain);
    }
}
