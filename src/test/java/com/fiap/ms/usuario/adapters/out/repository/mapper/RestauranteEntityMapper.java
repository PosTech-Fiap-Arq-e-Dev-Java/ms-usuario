package com.fiap.ms.usuario.adapters.out.repository.mapper;

import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteEntityMapperTest {

    private final RestauranteEntityMapper mapper = Mappers.getMapper(RestauranteEntityMapper.class);

    @Test
    void deveMapearRestauranteDomainParaRestauranteEntity() {
        RestauranteDomain domain = new RestauranteDomain();
        domain.setNome("Restaurante Teste");
        domain.setEmail("teste@restaurante.com");
        domain.setTelefone("123456789");
        domain.setEndereco("Rua Teste, 123");
        domain.setTipoCozinha("Italiana");
        domain.setHorarioFuncionamentoInicio("08:00");
        domain.setHorarioFuncionamentoFim("22:00");
        domain.setDonoRestaurante(true);

        RestauranteEntity entity = mapper.toRestauranteEntity(domain);

        assertNotNull(entity);
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getEmail(), entity.getEmail());
        assertEquals(domain.getTelefone(), entity.getTelefone());
        assertEquals(domain.getEndereco(), entity.getEndereco());
        assertEquals(domain.getTipoCozinha(), entity.getTipoCozinha());
        assertEquals(domain.getHorarioFuncionamentoInicio(), entity.getHorarioFuncionamentoInicio());
        assertEquals(domain.getHorarioFuncionamentoFim(), entity.getHorarioFuncionamentoFim());
        assertEquals(domain.getDonoRestaurante(), entity.getDonoRestaurante());
    }

    @Test
    void deveMapearRestauranteEntityParaRestauranteDomain() {
        // Arrange
        RestauranteEntity entity = new RestauranteEntity();
        entity.setNome("Restaurante Teste");
        entity.setEmail("teste@restaurante.com");
        entity.setTelefone("123456789");
        entity.setEndereco("Rua Teste, 123");
        entity.setTipoCozinha("Italiana");
        entity.setHorarioFuncionamentoInicio("08:00");
        entity.setHorarioFuncionamentoFim("22:00");
        entity.setDonoRestaurante(true);

        RestauranteDomain domain = mapper.toRestauranteDomain(entity);

        assertNotNull(domain);
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getEmail(), domain.getEmail());
        assertEquals(entity.getTelefone(), domain.getTelefone());
        assertEquals(entity.getEndereco(), domain.getEndereco());
        assertEquals(entity.getTipoCozinha(), domain.getTipoCozinha());
        assertEquals(entity.getHorarioFuncionamentoInicio(), domain.getHorarioFuncionamentoInicio());
        assertEquals(entity.getHorarioFuncionamentoFim(), domain.getHorarioFuncionamentoFim());
        assertEquals(entity.getDonoRestaurante(), domain.getDonoRestaurante());
    }
}
