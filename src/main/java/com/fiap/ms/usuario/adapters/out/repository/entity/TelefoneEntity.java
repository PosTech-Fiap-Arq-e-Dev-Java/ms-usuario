package com.fiap.ms.usuario.adapters.out.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class TelefoneEntity {

    @Column(name = "telefone_ddd")
    private Integer ddd;

    @Column(name = "telefone_numero")
    private Integer numero;
}
