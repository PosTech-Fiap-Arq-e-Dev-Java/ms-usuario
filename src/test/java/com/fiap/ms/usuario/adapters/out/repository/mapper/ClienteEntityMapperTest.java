package com.fiap.ms.usuario.adapters.out.repository.mapper;

import com.fiap.ms.usuario.adapters.out.repository.entity.ClienteEntity;
import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEntityMapperTest {

    private final ClienteEntityMapper mapper = ClienteEntityMapper.INSTANCE;

    @Test
    void toClienteEntity_deveConverterDomainParaEntity() {
        // Arrange
        ClienteDomain domain = new ClienteDomain();
        domain.setId(123L);
        domain.setNome("João");
        domain.setEmail("joao@example.com");

        ClienteEntity entity = mapper.toClienteEntity(domain);

        assertNotNull(entity);
        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getEmail(), entity.getEmail());
    }

    @Test
    void toClienteDomain_deveConverterEntityParaDomain() {
        // Arrange
        ClienteEntity entity = new ClienteEntity();
        entity.setId(456L);
        entity.setNome("Maria");
        entity.setEmail("maria@example.com");

        ClienteDomain domain = mapper.toClienteDomain(entity);

        assertNotNull(domain);
        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getEmail(), domain.getEmail());
    }
}


