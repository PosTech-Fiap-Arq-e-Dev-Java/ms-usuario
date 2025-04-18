package com.fiap.ms.usuario.adapters.out.repository;

import com.fiap.ms.usuario.adapters.out.repository.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
}
