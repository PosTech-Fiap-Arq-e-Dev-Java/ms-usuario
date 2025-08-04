package com.fiap.ms.usuario.application.core.handler.impl;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.usuario.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.core.handler.RestauranteValidatorHandler;
import org.springframework.stereotype.Component;

@Component
public class RestauranteValidatorHandlerImpl implements RestauranteValidatorHandler {

    @Override
    public void validarCamposObrigatoriosRestaurante(RestauranteDomain restauranteDomain) {
        if (restauranteDomain == null
                || isBlank(restauranteDomain.getEmail())
                || isBlank(restauranteDomain.getTelefone())
                || isBlank(restauranteDomain.getNome())
                || isBlank(restauranteDomain.getEndereco())
                || isBlank(restauranteDomain.getUsuario())
                || isBlank(restauranteDomain.getTipoCozinha())
                || isBlank(restauranteDomain.getHorarioFuncionamentoInicio())
                || isBlank(restauranteDomain.getHorarioFuncionamentoFim())
                || restauranteDomain.getDonoRestaurante() == null) {
            throw new CampoObrigatorioException();
        }
    }

    @Override
    public void validarCamposObrigatoriosAtualizarRestaurante(RestauranteDomain restauranteDomain) {
        if (restauranteDomain == null
                || isBlank(restauranteDomain.getEmail())
                || isBlank(restauranteDomain.getTelefone())
                || isBlank(restauranteDomain.getNome())
                || isBlank(restauranteDomain.getEndereco())) {
            throw new CampoObrigatorioException();
        }
    }

    @Override
    public void validarDadosIguaisRestaurante(RestauranteDomain novo, RestauranteDomain existente) {
        if (equalsIgnoreCaseSafe(novo.getEmail(), existente.getEmail())
                && equalsIgnoreCaseSafe(novo.getTelefone(), existente.getTelefone())
                && equalsIgnoreCaseSafe(novo.getNome(), existente.getNome())
                && equalsIgnoreCaseSafe(novo.getEndereco(), existente.getEndereco())
                && equalsIgnoreCaseSafe(novo.getTipoCozinha(), existente.getTipoCozinha())
                && equalsIgnoreCaseSafe(novo.getHorarioFuncionamentoInicio(), existente.getHorarioFuncionamentoInicio())
                && equalsIgnoreCaseSafe(novo.getHorarioFuncionamentoFim(), existente.getHorarioFuncionamentoFim())
                && ((novo.getDonoRestaurante() == null && existente.getDonoRestaurante() == null)
                || (novo.getDonoRestaurante() != null && novo.getDonoRestaurante().equals(existente.getDonoRestaurante())))) {
            throw new AtualizarDadosIguaisException();
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    private boolean equalsIgnoreCaseSafe(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        return s1.equalsIgnoreCase(s2);
    }
}


