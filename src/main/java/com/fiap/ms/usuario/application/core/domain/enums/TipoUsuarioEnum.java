package com.fiap.ms.usuario.application.core.domain.enums;

public enum TipoUsuarioEnum {

    COMUM(1, "Comum"),
    PARCEIRO(2, "Parceiro");

    private final int id;
    private final String descricao;

    TipoUsuarioEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }


    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoUsuarioEnum fromId(int id) {
        for (TipoUsuarioEnum tipo : TipoUsuarioEnum.values()) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Id inválido para TipoUsuario: " + id);
    }
}
