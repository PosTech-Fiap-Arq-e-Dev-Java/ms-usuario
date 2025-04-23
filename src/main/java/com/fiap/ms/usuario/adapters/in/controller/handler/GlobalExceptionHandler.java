package com.fiap.ms.usuario.adapters.in.controller.handler;

import com.fiap.ms.usuario.adapters.in.controller.handler.dto.ErroCampo;
import com.fiap.ms.usuario.adapters.in.controller.handler.dto.ErroResponse;
import com.fiap.ms.usuario.application.exception.CampoObrigatorioException;
import com.fiap.ms.usuario.application.exception.UsuarioNaoEncontradoException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleUsuarioNaoEncontrado(
            UsuarioNaoEncontradoException ex,
            HttpServletRequest request ) {

        ErroResponse error = ErroResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CampoObrigatorioException.class)
    public ResponseEntity<ErroResponse> handleCampoObrigatorioException(
            CampoObrigatorioException ex,
            HttpServletRequest request) {

        String campo = ex.getCampo();

        ErroCampo erroCampo = new ErroCampo(campo, "Parâmetro obrigatório não informado. ");

        ErroResponse error = ErroResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message("Erro de validação nos parâmetros da requisiçao.")
                .path(request.getRequestURI())
                .errors(List.of(erroCampo))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErroResponse> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            HttpServletRequest request) {

        ErroResponse error = ErroResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message("Endpoint inválido. Verifique a URL.")
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
