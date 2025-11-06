package com.casa_camarim.dto;

public class LoginRequest {
    private String cpf;
    private String telefone;
    private String senha;
    private String nome;

    public LoginRequest() {}
    
    public LoginRequest(String telefone, String senha, String cpf, String nome) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.nome = nome;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}