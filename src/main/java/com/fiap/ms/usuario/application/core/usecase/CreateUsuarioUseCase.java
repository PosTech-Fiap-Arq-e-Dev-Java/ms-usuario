package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.ports.in.CreateUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.out.CreateUsuarioOutputPort;

public class CreateUsuarioUseCase implements CreateUsuarioInputPort {

    private final CreateUsuarioOutputPort createUsuarioOutputPort;

    public CreateUsuarioUseCase(
            CreateUsuarioOutputPort createUsuarioOutputPort
    ){
        this.createUsuarioOutputPort = createUsuarioOutputPort;
    }

    @Override
    public void salvar(Usuario usuario) {
        createUsuarioOutputPort.salvar(usuario);
    }
}
