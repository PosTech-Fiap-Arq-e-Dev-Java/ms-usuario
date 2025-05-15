//package com.fiap.ms.usuario.adapters.out;
//
//import com.fiap.ms.usuario.adapters.out.repository.UsuarioRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.mockito.Mockito.*;
//
//class DeletarUsuarioAdapterTest {
//
//    private UsuarioRepository repository;
//    private DeletarUsuarioAdapter adapter;
//
//    @BeforeEach
//    void setUp() {
//        repository = mock(UsuarioRepository.class);
//        adapter = new DeletarUsuarioAdapter(repository);
//    }
//
//    @Test
//    void testDeletarPorId() {
//        Long id = 1L;
//
//        adapter.deletarPorId(id);
//
//        verify(repository, times(1)).deleteById(id);
//    }
//}
//
