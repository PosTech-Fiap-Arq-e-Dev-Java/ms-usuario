//package com.fiap.ms.usuario.adapters.in.controller.handler;
//
//import com.fiap.ms.usuario.adapters.in.controller.handler.dto.ErroResponse;
//import com.fiap.ms.usuario.application.core.domain.exception.UsuarioNaoEncontradoException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class GlobalExceptionHandlerTest {
//
//    private GlobalExceptionHandler handler;
//    private HttpServletRequest request;
//
//    @BeforeEach
//    void setUp() {
//        handler = new GlobalExceptionHandler();
//        request = mock(HttpServletRequest.class);
//        when(request.getRequestURI()).thenReturn("/v1/clientes");
//    }
//
//    @Test
//    void testHandleUsuarioNaoEncontrado() {
//        UsuarioNaoEncontradoException ex = new UsuarioNaoEncontradoException("admin");
//
//        ResponseEntity<ErroResponse> response = handler.handleUsuarioNaoEncontrado(ex, request);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals("Usuário não encontrado: admin", Objects.requireNonNull(response.getBody()).getMessage());
//        assertEquals("/v1/clientes", response.getBody().getPath());
//    }
//
//    @Test
//    void testHandleCampoObrigatorioException() {
//        CampoObrigatorioException ex = new CampoObrigatorioException("login");
//
//        ResponseEntity<ErroResponse> response = handler.handleCampoObrigatorioException(ex, request);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Erro de validação nos parâmetros da requisiçao.", Objects.requireNonNull(response.getBody()).getMessage());
//        assertEquals(1, response.getBody().getErrors().size());
//        assertEquals("login", response.getBody().getErrors().get(0).getCampo());
//        assertEquals("Parâmetro obrigatório não informado. ", response.getBody().getErrors().get(0).getMensagem());
//    }
//
//    @Test
//    void testHandleNoHandlerFoundException() {
//        NoHandlerFoundException ex = new NoHandlerFoundException("GET", "/v1/invalido", null);
//
//        ResponseEntity<ErroResponse> response = handler.handleNoHandlerFoundException(ex, request);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Endpoint inválido. Verifique a URL.", Objects.requireNonNull(response.getBody()).getMessage());
//        assertEquals("/v1/clientes", response.getBody().getPath());
//    }
//}
