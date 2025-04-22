package com.fiap.ms.usuario.adapters.in.controller.handler.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroCampo {
    private String campo;
    private String mensagem;
}
