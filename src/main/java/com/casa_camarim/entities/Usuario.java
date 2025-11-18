package com.casa_camarim.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column(nullable = false)
    private String senha;

    // Correção importante:
    // Removido CascadeType.ALL para evitar deleção acidental em efeito cascata.
    // JsonIgnore impede loop ao serializar.
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nome, String telefone, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    // Getters e Setters
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

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
