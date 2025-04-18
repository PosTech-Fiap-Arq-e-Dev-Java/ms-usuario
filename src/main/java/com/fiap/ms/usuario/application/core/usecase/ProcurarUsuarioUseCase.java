package com.fiap.ms.usuario.application.core.usecase;

import com.fiap.ms.usuario.application.core.domain.Usuario;
import com.fiap.ms.usuario.application.ports.in.ProcurarUsuarioInputPort;
import com.fiap.ms.usuario.application.ports.out.ProcurarUsuarioOutputPort;

public class ProcurarUsuarioUseCase implements ProcurarUsuarioInputPort {

    private final ProcurarUsuarioOutputPort procurarUsuarioOutputPort;

    public ProcurarUsuarioUseCase(ProcurarUsuarioOutputPort procurarUsuarioOutputPort) {
        this.procurarUsuarioOutputPort = procurarUsuarioOutputPort;
    }

    @Override
    public Usuario buscar(String admin) {
        return procurarUsuarioOutputPort.buscar(admin);
    }
}
