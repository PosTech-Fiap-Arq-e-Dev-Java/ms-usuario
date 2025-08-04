package com.fiap.ms.usuario.application.core.handler.impl;

import com.fiap.ms.usuario.application.core.domain.ClienteDomain;
import com.fiap.ms.usuario.application.core.domain.exception.AtualizarDadosIguaisException;
import com.fiap.ms.usuario.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.core.handler.ClienteValidatorHandler;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidatorHandlerImpl implements ClienteValidatorHandler {

    @Override
    public void validarCamposObrigatoriosCliente(ClienteDomain clienteDomain) {
        if (clienteDomain == null
                || isBlank(clienteDomain.getEmail())
                || isBlank(clienteDomain.getTelefone())
                || isBlank(clienteDomain.getNome())
                || isBlank(clienteDomain.getEndereco())
                || isBlank(clienteDomain.getUsuario())) {
            throw new CampoObrigatorioException();
        }
    }

    @Override
    public void validarCamposObrigatoriosAtualizarCliente(ClienteDomain clienteDomain) {
        if (clienteDomain == null
                || isBlank(clienteDomain.getEmail())
                || isBlank(clienteDomain.getTelefone())
                || isBlank(clienteDomain.getNome())
                || isBlank(clienteDomain.getEndereco())) {
            throw new CampoObrigatorioException();
        }
    }

    @Override
    public void validarDadosIguaisCliente(ClienteDomain novo, ClienteDomain existente) {
        if (equalsIgnoreCaseSafe(novo.getEmail(), existente.getEmail())
                && equalsIgnoreCaseSafe(novo.getTelefone(), existente.getTelefone())
                && equalsIgnoreCaseSafe(novo.getNome(), existente.getNome())
                && equalsIgnoreCaseSafe(novo.getEndereco(), existente.getEndereco())
                && equalsIgnoreCaseSafe(novo.getUsuario(), existente.getUsuario())) {
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

