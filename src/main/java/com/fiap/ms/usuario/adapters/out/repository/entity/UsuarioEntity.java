package com.fiap.ms.usuario.adapters.out.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_email")
    private String email;

    @Embedded
    @Column(name = "usuario_telefone")
    private TelefoneEntity telefone;

    @Embedded
    @Column(name = "usuario_endereco")
    private EnderecoEntity endereco;

    @Column(name = "usuario_login")
    private String login;

    @Column(name = "usuario_senha")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "tb_tipo_usuario_id")
    private TipoUsuarioEntity tipoUsuario;

    @Column(name = "usuario_data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "usuario_data_exclusao")
    private LocalDateTime dataExclusao;

    @Column(name = "usuario_ativo")
    private Boolean usuarioAtivo;

}
