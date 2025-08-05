package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarClienteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.ClienteDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteDtoMapperTest {

    private final ClienteDtoMapper mapper = Mappers.getMapper(ClienteDtoMapper.class);

    @Test
    void testToClienteDomain() {
        ClienteDto dto = new ClienteDto();
        dto.setUsuario("usuario1");
        dto.setNome("Nome Teste");
        dto.setEmail("teste@email.com");
        dto.setTelefone("123456789");
        dto.setEndereco("Rua A, 123");

        ClienteDomain domain = mapper.toClienteDomain(dto);

        assertNull(domain.getId());
        assertEquals(dto.getUsuario(), domain.getUsuario());
        assertEquals(dto.getNome(), domain.getNome());
        assertEquals(dto.getEmail(), domain.getEmail());
        assertEquals(dto.getTelefone(), domain.getTelefone());
        assertEquals(dto.getEndereco(), domain.getEndereco());
    }

    @Test
    void testToClienteDto() {
        ClienteDomain domain = new ClienteDomain();
        domain.setUsuario("usuario2");
        domain.setNome("Outro Nome");
        domain.setEmail("outro@email.com");
        domain.setTelefone("987654321");
        domain.setEndereco("Rua B, 456");

        ClienteDto dto = mapper.toClienteDto(domain);

        assertEquals(domain.getUsuario(), dto.getUsuario());
        assertEquals(domain.getNome(), dto.getNome());
        assertEquals(domain.getEmail(), dto.getEmail());
        assertEquals(domain.getTelefone(), dto.getTelefone());
        assertEquals(domain.getEndereco(), dto.getEndereco());
    }

    @Test
    void testToClienteDomainUpdate() {
        AtualizarClienteRequestDto atualizarDto = new AtualizarClienteRequestDto();
        atualizarDto.setNome("Nome Update");
        atualizarDto.setEmail("update@email.com");
        atualizarDto.setTelefone("1122334455");
        atualizarDto.setEndereco("Rua Update, 789");

        ClienteDomain domain = mapper.toClienteDomainUpdate(atualizarDto);

        assertNull(domain.getId());
        assertNull(domain.getUsuario());
        assertEquals(atualizarDto.getNome(), domain.getNome());
        assertEquals(atualizarDto.getEmail(), domain.getEmail());
        assertEquals(atualizarDto.getTelefone(), domain.getTelefone());
        assertEquals(atualizarDto.getEndereco(), domain.getEndereco());
    }
}
