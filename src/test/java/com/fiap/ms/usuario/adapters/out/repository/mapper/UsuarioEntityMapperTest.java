//package com.fiap.ms.usuario.adapters.out.repository.mapper;
//
//import com.fiap.ms.usuario.adapters.out.repository.entity.TipoUsuarioEntity;
//import com.fiap.ms.usuario.adapters.out.repository.entity.UsuarioEntity;
//import com.fiap.ms.usuario.application.core.domain.Usuario;
//import com.fiap.ms.usuario.application.core.domain.enums.TipoUsuarioEnum;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UsuarioEntityMapperTest {
//
//    private UsuarioEntityMapper mapper;
//
//    @BeforeEach
//    void setUp() {
//        mapper = Mappers.getMapper(UsuarioEntityMapper.class);
//    }
//
//    @Test
//    void testToUsuarioEntity() {
//        Usuario usuario = new Usuario();
//        usuario.setLogin("admin");
//        usuario.setTipoUsuario(TipoUsuarioEnum.PARCEIRO);
//
//        UsuarioEntity entity = mapper.toUsuarioEntity(usuario);
//
//        assertNotNull(entity);
//        assertEquals("admin", entity.getLogin());
//        assertNotNull(entity.getTipoUsuario());
//        assertEquals(TipoUsuarioEnum.PARCEIRO.getId(), entity.getTipoUsuario().getId().intValue());
//        assertEquals(TipoUsuarioEnum.PARCEIRO.getDescricao(), entity.getTipoUsuario().getDescricao());
//    }
//
//    @Test
//    void testToUsuario() {
//        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity();
//        tipoUsuarioEntity.setId(2L);
//        tipoUsuarioEntity.setDescricao("Parceiro");
//
//        UsuarioEntity entity = new UsuarioEntity();
//        entity.setLogin("admin");
//        entity.setTipoUsuario(tipoUsuarioEntity);
//
//        Usuario usuario = mapper.toUsuario(entity);
//
//        assertNotNull(usuario);
//        assertEquals("admin", usuario.getLogin());
//        assertEquals(TipoUsuarioEnum.PARCEIRO, usuario.getTipoUsuario());
//    }
//
//    @Test
//    void testMapTipoUsuarioEnumToEntity() {
//        TipoUsuarioEnum tipo = TipoUsuarioEnum.COMUM;
//        TipoUsuarioEntity entity = mapper.map(tipo);
//
//        assertNotNull(entity);
//        assertEquals(tipo.getId(), entity.getId().intValue());
//        assertEquals(tipo.getDescricao(), entity.getDescricao());
//    }
//
//    @Test
//    void testMapTipoUsuarioEntityToEnum() {
//        TipoUsuarioEntity entity = new TipoUsuarioEntity();
//        entity.setId(1L);
//        entity.setDescricao("Comum");
//
//        TipoUsuarioEnum tipo = mapper.map(entity);
//
//        assertEquals(TipoUsuarioEnum.COMUM, tipo);
//    }
//
//    @Test
//    void testMapTipoUsuarioEntityToEnumInvalidId() {
//        TipoUsuarioEntity entity = new TipoUsuarioEntity();
//        entity.setId(99L);
//        entity.setDescricao("Inválido");
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            mapper.map(entity);
//        });
//
//        assertTrue(exception.getMessage().contains("TipoUsuarioEntity inválido"));
//    }
//}
