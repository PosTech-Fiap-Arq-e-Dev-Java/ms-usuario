package com.fiap.ms.usuario.adapters.out.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteEntityTest {

        @Test
        void testEqualsAndHashCode() {
            RestauranteEntity r1 = new RestauranteEntity(
                    1L,
                    "Restaurante A",
                    "usuarioA",
                    "email@a.com",
                    "123456789",
                    "Endereco A",
                    "Italiana",
                    "08:00",
                    "22:00",
                    true
            );

            RestauranteEntity r2 = new RestauranteEntity(
                    1L,
                    "Restaurante A",
                    "usuarioA",
                    "email@a.com",
                    "123456789",
                    "Endereco A",
                    "Italiana",
                    "08:00",
                    "22:00",
                    true
            );

            RestauranteEntity r3 = new RestauranteEntity(
                    2L,
                    "Restaurante B",
                    "usuarioB",
                    "email@b.com",
                    "987654321",
                    "Endereco B",
                    "Japonesa",
                    "09:00",
                    "23:00",
                    false
            );

            assertEquals(r1, r2);
            assertEquals(r1.hashCode(), r2.hashCode());
            assertNotEquals(r1, r3);
            assertNotEquals(r1.hashCode(), r3.hashCode());
        }

    @Test
    void testNoArgsConstructorAndSettersAndGetters() {
        RestauranteEntity restaurante = new RestauranteEntity();

        restaurante.setId(1L);
        restaurante.setNome("Restaurante Teste");
        restaurante.setUsuario("restaurante123");
        restaurante.setEmail("teste@restaurante.com");
        restaurante.setTelefone("123456789");
        restaurante.setEndereco("Rua A, 100");
        restaurante.setTipoCozinha("Italiana");
        restaurante.setHorarioFuncionamentoInicio("08:00");
        restaurante.setHorarioFuncionamentoFim("22:00");
        restaurante.setDonoRestaurante(true);

        assertEquals(1L, restaurante.getId());
        assertEquals("Restaurante Teste", restaurante.getNome());
        assertEquals("restaurante123", restaurante.getUsuario());
        assertEquals("teste@restaurante.com", restaurante.getEmail());
        assertEquals("123456789", restaurante.getTelefone());
        assertEquals("Rua A, 100", restaurante.getEndereco());
        assertEquals("Italiana", restaurante.getTipoCozinha());
        assertEquals("08:00", restaurante.getHorarioFuncionamentoInicio());
        assertEquals("22:00", restaurante.getHorarioFuncionamentoFim());
        assertTrue(restaurante.getDonoRestaurante());
    }

    @Test
    void testAllArgsConstructor() {
        RestauranteEntity restaurante = new RestauranteEntity(
                2L,
                "Restaurante Bom",
                "restaurante456",
                "bom@restaurante.com",
                "987654321",
                "Rua B, 200",
                "Japonesa",
                "10:00",
                "23:00",
                false
        );

        assertEquals(2L, restaurante.getId());
        assertEquals("Restaurante Bom", restaurante.getNome());
        assertEquals("restaurante456", restaurante.getUsuario());
        assertEquals("bom@restaurante.com", restaurante.getEmail());
        assertEquals("987654321", restaurante.getTelefone());
        assertEquals("Rua B, 200", restaurante.getEndereco());
        assertEquals("Japonesa", restaurante.getTipoCozinha());
        assertEquals("10:00", restaurante.getHorarioFuncionamentoInicio());
        assertEquals("23:00", restaurante.getHorarioFuncionamentoFim());
        assertFalse(restaurante.getDonoRestaurante());
    }

    @Test
    void testToString() {
        RestauranteEntity restaurante = new RestauranteEntity(
                3L,
                "Restaurante Legal",
                "restaurante789",
                "legal@restaurante.com",
                "1122334455",
                "Rua C, 300",
                "Mexicana",
                "07:00",
                "21:00",
                true
        );
        String toString = restaurante.toString();

        assertTrue(toString.contains("id=3"));
        assertTrue(toString.contains("nome=Restaurante Legal"));
        assertTrue(toString.contains("usuario=restaurante789"));
        assertTrue(toString.contains("email=legal@restaurante.com"));
        assertTrue(toString.contains("telefone=1122334455"));
        assertTrue(toString.contains("endereco=Rua C, 300"));
        assertTrue(toString.contains("tipoCozinha=Mexicana"));
        assertTrue(toString.contains("horarioFuncionamentoInicio=07:00"));
        assertTrue(toString.contains("horarioFuncionamentoFim=21:00"));
        assertTrue(toString.contains("donoRestaurante=true"));
    }
}
