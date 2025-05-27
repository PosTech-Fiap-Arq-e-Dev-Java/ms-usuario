package com.fiap.ms.usuario.application.core;

import com.fiap.ms.usuario.application.core.domain.UsuarioDomain;
import com.fiap.ms.usuario.application.core.domain.exception.UsuarioJaExistenteException;
import com.fiap.ms.usuario.application.core.handler.UsuarioValidatorHandler;
import com.fiap.ms.usuario.application.ports.out.BuscarClienteOutputPort;
import com.fiap.ms.usuario.application.ports.out.InserirClienteOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fiap.ms.usuario.common.config.MockUsuario.getUsuarioDomain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InserirClienteUseCaseTest {

    @Mock
    private InserirClienteOutputPort inserirClienteOutputPort;

    @Mock
    private BuscarClienteOutputPort buscarClienteOutputPort;

    @Mock
    private UsuarioValidatorHandler usuarioValidatorHandler;

    @InjectMocks
    private InserirClienteUseCase inserirClienteUseCase;

    @Test
    void deveInserirUsuarioQuandoNaoExiste() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();

        when(buscarClienteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                        usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail()))
                .thenReturn(Optional.empty());

        inserirClienteUseCase.inserir(usuarioDomain);

        verify(usuarioValidatorHandler).validarCamposObrigatoriosUsuario(usuarioDomain);
        verify(inserirClienteOutputPort).inserir(usuarioDomain);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioJaExiste() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();

        when(buscarClienteOutputPort.buscarPorUsuarioOuTelefoneOuEmail(
                        usuarioDomain.getUsuario(), usuarioDomain.getTelefone(), usuarioDomain.getEmail()))
                .thenReturn(Optional.of(new UsuarioDomain()));

        assertThrows(UsuarioJaExistenteException.class, () -> inserirClienteUseCase.inserir(usuarioDomain));

        verify(usuarioValidatorHandler).validarCamposObrigatoriosUsuario(usuarioDomain);
        verifyNoMoreInteractions(inserirClienteOutputPort);
    }

    @Test
    void deveLancarErroDeValidacaoQuandoCamposInvalidos() {
        UsuarioDomain usuarioDomain = new UsuarioDomain();

        doThrow(new IllegalArgumentException("Campos obrigatórios inválidos"))
                .when(usuarioValidatorHandler).validarCamposObrigatoriosUsuario(usuarioDomain);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inserirClienteUseCase.inserir(usuarioDomain));

        assertEquals("Campos obrigatórios inválidos", exception.getMessage());
        verifyNoInteractions(inserirClienteOutputPort);
    }
}
