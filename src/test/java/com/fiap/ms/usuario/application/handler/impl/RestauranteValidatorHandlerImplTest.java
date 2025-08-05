package com.fiap.ms.usuario.application.handler.impl;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.usuario.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.core.handler.impl.RestauranteValidatorHandlerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteValidatorHandlerImplTest {

    private RestauranteValidatorHandlerImpl validator;

    @BeforeEach
    void setup() {
        validator = new RestauranteValidatorHandlerImpl();
    }

    @Test
    void validarCamposObrigatoriosRestaurante_deveLancarQuandoCampoObrigatorioNuloOuVazio() {
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(null));

        RestauranteDomain r = new RestauranteDomain();
        r.setEmail("  ");
        r.setTelefone("123");
        r.setNome("Nome");
        r.setEndereco("Endereco");
        r.setUsuario("usuario");
        r.setTipoCozinha("Italiana");
        r.setHorarioFuncionamentoInicio("08:00");
        r.setHorarioFuncionamentoFim("22:00");
        r.setDonoRestaurante(true);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setEmail("email@email.com");
        r.setTelefone(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setTelefone("123");
        r.setNome("");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setNome("Nome");
        r.setEndereco(" ");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setEndereco("Endereco");
        r.setUsuario(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setUsuario("usuario");
        r.setTipoCozinha("");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setTipoCozinha("Italiana");
        r.setHorarioFuncionamentoInicio(" ");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setHorarioFuncionamentoInicio("08:00");
        r.setHorarioFuncionamentoFim(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));

        r.setHorarioFuncionamentoFim("22:00");
        r.setDonoRestaurante(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosRestaurante(r));
    }

    @Test
    void validarCamposObrigatoriosAtualizarRestaurante_deveLancarQuandoCampoObrigatorioNuloOuVazio() {
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(null));

        RestauranteDomain r = new RestauranteDomain();
        r.setEmail("  ");
        r.setTelefone("123");
        r.setNome("Nome");
        r.setEndereco("Endereco");
        r.setTipoCozinha("Italiana");
        r.setHorarioFuncionamentoInicio("08:00");
        r.setHorarioFuncionamentoFim("22:00");
        r.setDonoRestaurante(true);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setEmail("email@email.com");
        r.setTelefone(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setTelefone("123");
        r.setNome("");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setNome("Nome");
        r.setEndereco(" ");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setEndereco("Endereco");
        r.setTipoCozinha(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setTipoCozinha("Italiana");
        r.setDonoRestaurante(null);
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setDonoRestaurante(true);
        r.setHorarioFuncionamentoFim("");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));

        r.setHorarioFuncionamentoFim("22:00");
        r.setHorarioFuncionamentoInicio(" ");
        assertThrows(CampoObrigatorioException.class, () -> validator.validarCamposObrigatoriosAtualizarRestaurante(r));
    }

    @Test
    void validarDadosIguaisRestaurante_deveLancarQuandoDadosSaoIguais() {
        RestauranteDomain novo = new RestauranteDomain();
        novo.setEmail("Email@exemplo.com");
        novo.setTelefone("123");
        novo.setNome("Nome");
        novo.setEndereco("Endereco");
        novo.setTipoCozinha("Italiana");
        novo.setHorarioFuncionamentoInicio("08:00");
        novo.setHorarioFuncionamentoFim("22:00");
        novo.setDonoRestaurante(true);

        RestauranteDomain existente = new RestauranteDomain();
        existente.setEmail("email@EXEMPLO.com");
        existente.setTelefone("123");
        existente.setNome("nome");
        existente.setEndereco("endereco");
        existente.setTipoCozinha("italiana");
        existente.setHorarioFuncionamentoInicio("08:00");
        existente.setHorarioFuncionamentoFim("22:00");
        existente.setDonoRestaurante(true);

        assertThrows(AtualizarDadosIguaisException.class,
                () -> validator.validarDadosIguaisRestaurante(novo, existente));
    }

    @Test
    void validarDadosIguaisRestaurante_naoDeveLancarQuandoDadosSaoDiferentes() {
        RestauranteDomain novo = new RestauranteDomain();
        novo.setEmail("email1@exemplo.com");
        novo.setTelefone("123");
        novo.setNome("Nome");
        novo.setEndereco("Endereco");
        novo.setTipoCozinha("Italiana");
        novo.setHorarioFuncionamentoInicio("08:00");
        novo.setHorarioFuncionamentoFim("22:00");
        novo.setDonoRestaurante(true);

        RestauranteDomain existente = new RestauranteDomain();
        existente.setEmail("email2@exemplo.com"); // diferente
        existente.setTelefone("123");
        existente.setNome("nome");
        existente.setEndereco("endereco");
        existente.setTipoCozinha("italiana");
        existente.setHorarioFuncionamentoInicio("08:00");
        existente.setHorarioFuncionamentoFim("22:00");
        existente.setDonoRestaurante(true);

        assertDoesNotThrow(() -> validator.validarDadosIguaisRestaurante(novo, existente));
    }

    @Test
    void validarDadosIguaisRestaurante_deveTratarNullsCorretamente() {
        RestauranteDomain novo = new RestauranteDomain();
        novo.setEmail(null);
        novo.setTelefone(null);
        novo.setNome(null);
        novo.setEndereco(null);
        novo.setTipoCozinha(null);
        novo.setHorarioFuncionamentoInicio(null);
        novo.setHorarioFuncionamentoFim(null);
        novo.setDonoRestaurante(null);

        RestauranteDomain existente = new RestauranteDomain();
        existente.setEmail(null);
        existente.setTelefone(null);
        existente.setNome(null);
        existente.setEndereco(null);
        existente.setTipoCozinha(null);
        existente.setHorarioFuncionamentoInicio(null);
        existente.setHorarioFuncionamentoFim(null);
        existente.setDonoRestaurante(null);

        assertThrows(AtualizarDadosIguaisException.class,
                () -> validator.validarDadosIguaisRestaurante(novo, existente));

        existente.setEmail("email");
        assertDoesNotThrow(() -> validator.validarDadosIguaisRestaurante(novo, existente));
    }
}

