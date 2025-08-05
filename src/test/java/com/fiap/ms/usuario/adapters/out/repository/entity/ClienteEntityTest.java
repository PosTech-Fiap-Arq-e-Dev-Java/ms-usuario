package com.fiap.ms.usuario.adapters.out.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEntityTest {

        @Test
        void testEqualsAndHashCode() {
            ClienteEntity c1 = new ClienteEntity(
                    1L,
                    "João",
                    "joao123",
                    "joao@email.com",
                    "123456789",
                    "Rua A, 100"
            );

            ClienteEntity c2 = new ClienteEntity(
                    1L,
                    "João",
                    "joao123",
                    "joao@email.com",
                    "123456789",
                    "Rua A, 100"
            );

            ClienteEntity c3 = new ClienteEntity(
                    2L,
                    "Maria",
                    "maria456",
                    "maria@email.com",
                    "987654321",
                    "Rua B, 200"
            );

            assertEquals(c1, c2);
            assertEquals(c1.hashCode(), c2.hashCode());

            assertNotEquals(c1, c3);
            assertNotEquals(c1.hashCode(), c3.hashCode());
        }

    @Test
    void testNoArgsConstructorAndSettersAndGetters() {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setId(1L);
        cliente.setNome("João");
        cliente.setUsuario("joao123");
        cliente.setEmail("joao@email.com");
        cliente.setTelefone("123456789");
        cliente.setEndereco("Rua A, 100");

        assertEquals(1L, cliente.getId());
        assertEquals("João", cliente.getNome());
        assertEquals("joao123", cliente.getUsuario());
        assertEquals("joao@email.com", cliente.getEmail());
        assertEquals("123456789", cliente.getTelefone());
        assertEquals("Rua A, 100", cliente.getEndereco());
    }

    @Test
    void testAllArgsConstructor() {
        ClienteEntity cliente = new ClienteEntity(
                2L,
                "Maria",
                "maria456",
                "maria@email.com",
                "987654321",
                "Rua B, 200"
        );

        assertEquals(2L, cliente.getId());
        assertEquals("Maria", cliente.getNome());
        assertEquals("maria456", cliente.getUsuario());
        assertEquals("maria@email.com", cliente.getEmail());
        assertEquals("987654321", cliente.getTelefone());
        assertEquals("Rua B, 200", cliente.getEndereco());
    }


    @Test
    void testToString() {
        ClienteEntity cliente = new ClienteEntity(3L, "Carlos", "carlos789", "carlos@email.com", "1122334455", "Rua C, 300");
        String toString = cliente.toString();

        assertTrue(toString.contains("id=3"));
        assertTrue(toString.contains("nome=Carlos"));
        assertTrue(toString.contains("usuario=carlos789"));
        assertTrue(toString.contains("email=carlos@email.com"));
        assertTrue(toString.contains("telefone=1122334455"));
        assertTrue(toString.contains("endereco=Rua C, 300"));
    }
}
