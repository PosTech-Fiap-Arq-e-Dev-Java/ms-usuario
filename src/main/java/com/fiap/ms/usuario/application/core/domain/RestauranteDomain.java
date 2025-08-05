package com.fiap.ms.usuario.application.core.domain;

public class RestauranteDomain {

    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private String usuario;
    private String tipoCozinha;
    private String horarioFuncionamentoInicio;
    private String horarioFuncionamentoFim;
    private Boolean donoRestaurante;

    public RestauranteDomain(){
    }

    public RestauranteDomain(Long id, String nome, String email, String endereco, String telefone, String usuario,
                             String tipoCozinha, String horarioFuncionamentoInicio, String horarioFuncionamentoFim, Boolean donoRestaurante) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.usuario = usuario;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamentoInicio = horarioFuncionamentoInicio;
        this.horarioFuncionamentoFim = horarioFuncionamentoFim;
        this.donoRestaurante = donoRestaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(String tipoCozinha){
        this.tipoCozinha = tipoCozinha;
    }

    public String getHorarioFuncionamentoInicio(){
        return horarioFuncionamentoInicio;
    }

    public void setHorarioFuncionamentoInicio(String horarioFuncionamentoInicio){
        this.horarioFuncionamentoInicio = horarioFuncionamentoInicio;
    }

    public String getHorarioFuncionamentoFim(){
        return horarioFuncionamentoFim;
    }

    public void setHorarioFuncionamentoFim(String horarioFuncionamentoFim) {
        this.horarioFuncionamentoFim = horarioFuncionamentoFim;
    }

    public Boolean getDonoRestaurante() {
        return donoRestaurante;
    }

    public void setDonoRestaurante(Boolean donoRestaurante) {
        this.donoRestaurante = donoRestaurante;
    }
}
