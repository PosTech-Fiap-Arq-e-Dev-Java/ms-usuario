package com.fiap.ms.usuario.application.core.domain;

import com.fiap.ms.usuario.application.core.domain.enums.TipoUsuarioEnum;

import java.time.LocalDateTime;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private Telefone telefone;
    private Endereco endereco;
    private String login;
    private String senha;
    private TipoUsuarioEnum tipoUsuario;
    private LocalDateTime dataAlteracao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExclusao;
    private Boolean usuarioAtivo;

    public Usuario(){
    }

    public Usuario(Integer id, String nome, String email, Telefone telefone, Endereco endereco, String login, String senha, TipoUsuarioEnum tipoUsuario, LocalDateTime dataAlteracao, LocalDateTime dataCriacao, LocalDateTime dataExclusao, Boolean usuarioAtivo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.dataAlteracao = dataAlteracao;
        this.dataCriacao = dataCriacao;
        this.dataExclusao = dataExclusao;
        this.usuarioAtivo = usuarioAtivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(LocalDateTime dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Boolean getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(Boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }
}
