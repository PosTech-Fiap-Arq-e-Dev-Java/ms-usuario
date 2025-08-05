package com.fiap.ms.usuario.adapters.in.controller.handler;

import com.fiap.ms.usuario.application.core.domain.exception.*;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;
    private WebRequest webRequest;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
        webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("uri=/test/path");
    }

    private void assertResponse(ResponseEntity<Object> response, int expectedStatus, String expectedError, String expectedMessage, String expectedPath) {
        assertEquals(expectedStatus, response.getStatusCodeValue());

        Object bodyObj = response.getBody();
        assertNotNull(bodyObj);
        assertTrue(bodyObj instanceof Map);

        Map<?, ?> body = (Map<?, ?>) bodyObj;
        assertEquals(expectedStatus, body.get("status"));
        assertEquals(expectedError, body.get("error"));
        assertEquals(expectedMessage, body.get("message"));
        assertEquals(expectedPath, body.get("path"));
        assertTrue(body.get("timestamp") instanceof OffsetDateTime);
    }

    @Test
    void testHandleNoHandlerFoundException() {
        NoHandlerFoundException ex = mock(NoHandlerFoundException.class);
        ResponseEntity<Object> response = handler.handleNoHandlerFoundException(ex, webRequest);

        assertResponse(response, 400, "Bad Request", "Endpoint inválido. Verifique a URL.", "/test/path");
    }

    @Test
    void testHandleMissingParams() {
        MissingServletRequestParameterException ex = new MissingServletRequestParameterException("param", "String");
        ResponseEntity<Object> response = handler.handleMissingParams(ex, webRequest);

        assertResponse(response, 400, "Bad Request", "O parâmetro 'param' é obrigatório.", "/test/path");
    }

    @Test
    void testHandleUsuarioJaExistente() {
        UsuarioJaExistenteException ex = new UsuarioJaExistenteException();
        ResponseEntity<Object> response = handler.handleUsuarioJaExistente(ex, webRequest);

        assertResponse(response, 409, "CONFLICT", ex.getReason(), "/test/path");
    }

    @Test
    void testHandleCampoObrigatorio() {
        CampoObrigatorioException ex = new CampoObrigatorioException();
        ResponseEntity<Object> response = handler.handleCampoObrigatorio(ex, webRequest);

        assertResponse(response, 400, "BAD_REQUEST", ex.getReason(), "/test/path");
    }

    @Test
    void testHandleUsuarioNaoEncontrado() {
        UsuarioNaoEncontradoException ex = new UsuarioNaoEncontradoException("usuario123");
        ResponseEntity<Object> response = handler.handleUsuarioNaoEncontrado(ex, webRequest);

        assertResponse(response, 404, "NOT_FOUND", ex.getReason(), "/test/path");
    }

    @Test
    void testHandleAtualizarDadosIguais() {
        AtualizarDadosIguaisException ex = new AtualizarDadosIguaisException();
        ResponseEntity<Object> response = handler.handleAtualizarDadosIguais(ex, webRequest);

        assertResponse(response, 409, "CONFLICT", ex.getReason(), "/test/path");
    }

    @Test
    void testHandleUnrecognizedPropertyException() throws Exception {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        JsonLocation mockLocation = Mockito.mock(JsonLocation.class);
        Mockito.when(mockParser.getCurrentLocation()).thenReturn(mockLocation);

        UnrecognizedPropertyException ex = new UnrecognizedPropertyException(
                mockParser,
                "Propriedade JSON desconhecida: 'propertyX'",
                mockLocation,
                null,
                "propertyX",
                null
        );

        ResponseEntity<Object> response = handler.handleUnrecognizedPropertyException(ex, webRequest);

        assertResponse(response, 400, "BAD_REQUEST", "Propriedade JSON desconhecida: 'propertyX'", "/test/path");
    }

}

