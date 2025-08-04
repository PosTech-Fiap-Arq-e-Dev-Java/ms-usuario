package com.fiap.ms.usuario.application.core.handler;


import com.fiap.ms.usuario.application.core.domain.ClienteDomain;

public interface ClienteValidatorHandler {

    void validarCamposObrigatoriosCliente(ClienteDomain clienteDomain);
    void validarCamposObrigatoriosAtualizarCliente(ClienteDomain clienteDomain);
    void validarDadosIguaisCliente(ClienteDomain novo, ClienteDomain existente);
}

