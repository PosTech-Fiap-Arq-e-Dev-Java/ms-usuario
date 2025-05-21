package com.fiap.ms.usuario.adapters.out.repository;

import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {

    Optional<RestauranteEntity> findByUsuario(String usuario);

    Optional<RestauranteEntity> findByUsuarioAndTelefoneAndEmail(String usuario, String telefone, String email);

}
