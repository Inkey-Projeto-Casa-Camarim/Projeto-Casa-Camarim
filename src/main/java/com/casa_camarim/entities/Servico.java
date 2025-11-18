package com.casa_camarim.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String preco;

    @Column(nullable = false)
    private String duracaoMinutos;

    @OneToMany(mappedBy = "servico")
    @JsonBackReference
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Servico() {}

    public Servico(String nome, String preco, String duracaoMinutos) {
        this.nome = nome;
        this.preco = preco;
        this.duracaoMinutos = duracaoMinutos;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(String duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
