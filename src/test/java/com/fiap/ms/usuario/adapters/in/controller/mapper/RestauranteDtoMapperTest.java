package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarRestauranteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.RestauranteDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteDtoMapperTest {

    private final RestauranteDtoMapper mapper = Mappers.getMapper(RestauranteDtoMapper.class);

    @Test
    void testToRestauranteDomain() {
        RestauranteDto dto = new RestauranteDto();
        dto.setUsuario("restaurante1");
        dto.setNome("Restaurante Teste");
        dto.setEmail("restaurante@email.com");
        dto.setTelefone("123456789");
        dto.setEndereco("Av Teste, 100");
        dto.setDonoRestaurante(true);
        dto.setHorarioFuncionamentoInicio("08:00");
        dto.setHorarioFuncionamentoFim("22:00");
        dto.setTipoCozinha("Italiana");

        RestauranteDomain domain = mapper.toRestauranteDomain(dto);

        assertNull(domain.getId());
        assertEquals(dto.getUsuario(), domain.getUsuario());
        assertEquals(dto.getNome(), domain.getNome());
        assertEquals(dto.getEmail(), domain.getEmail());
        assertEquals(dto.getTelefone(), domain.getTelefone());
        assertEquals(dto.getEndereco(), domain.getEndereco());
        assertEquals(dto.getDonoRestaurante(), domain.getDonoRestaurante());
        assertEquals(dto.getHorarioFuncionamentoInicio(), domain.getHorarioFuncionamentoInicio());
        assertEquals(dto.getHorarioFuncionamentoFim(), domain.getHorarioFuncionamentoFim());
        assertEquals(dto.getTipoCozinha(), domain.getTipoCozinha());
    }

    @Test
    void testToRestauranteDto() {
        RestauranteDomain domain = new RestauranteDomain();
        domain.setUsuario("restaurante2");
        domain.setNome("Restaurante Dois");
        domain.setEmail("rest2@email.com");
        domain.setTelefone("987654321");
        domain.setEndereco("Rua Dois, 200");
        domain.setDonoRestaurante(false);
        domain.setHorarioFuncionamentoInicio("07:00");
        domain.setHorarioFuncionamentoFim("23:00");
        domain.setTipoCozinha("Brasileira");

        RestauranteDto dto = mapper.toRestauranteDto(domain);

        assertEquals(domain.getUsuario(), dto.getUsuario());
        assertEquals(domain.getNome(), dto.getNome());
        assertEquals(domain.getEmail(), dto.getEmail());
        assertEquals(domain.getTelefone(), dto.getTelefone());
        assertEquals(domain.getEndereco(), dto.getEndereco());
        assertEquals(domain.getDonoRestaurante(), dto.getDonoRestaurante());
        assertEquals(domain.getHorarioFuncionamentoInicio(), dto.getHorarioFuncionamentoInicio());
        assertEquals(domain.getHorarioFuncionamentoFim(), dto.getHorarioFuncionamentoFim());
        assertEquals(domain.getTipoCozinha(), dto.getTipoCozinha());
    }

    @Test
    void testToRestauranteDomainUpdate() {
        AtualizarRestauranteRequestDto atualizarDto = new AtualizarRestauranteRequestDto();
        atualizarDto.setNome("Nome Atualizado");
        atualizarDto.setEmail("atualizado@email.com");
        atualizarDto.setTelefone("1122334455");
        atualizarDto.setEndereco("Rua Atualizada, 789");
        atualizarDto.setDonoRestaurante(true);
        atualizarDto.setHorarioFuncionamentoInicio("09:00");
        atualizarDto.setHorarioFuncionamentoFim("21:00");
        atualizarDto.setTipoCozinha("Mexicana");

        RestauranteDomain domain = mapper.toRestauranteDomainUpdate(atualizarDto);

        assertNull(domain.getId());
        assertNull(domain.getUsuario());
        assertEquals(atualizarDto.getNome(), domain.getNome());
        assertEquals(atualizarDto.getEmail(), domain.getEmail());
        assertEquals(atualizarDto.getTelefone(), domain.getTelefone());
        assertEquals(atualizarDto.getEndereco(), domain.getEndereco());
        assertEquals(atualizarDto.getDonoRestaurante(), domain.getDonoRestaurante());
        assertEquals(atualizarDto.getHorarioFuncionamentoInicio(), domain.getHorarioFuncionamentoInicio());
        assertEquals(atualizarDto.getHorarioFuncionamentoFim(), domain.getHorarioFuncionamentoFim());
        assertEquals(atualizarDto.getTipoCozinha(), domain.getTipoCozinha());
    }
}
