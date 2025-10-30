package com.casa_camarim.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico", nullable = false)
    private Long id_servico;

    @Column(name = "nome_servico", nullable = false, length = 150)
    private String nomeServico;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "descricao_servico", nullable = true, length = 255)
    private String descricaoServico;

    @Column(name = "tempo_servico", nullable = true, length = 50)
    private String tempoServico;

    // 🔗 Relacionamento ManyToMany com Agenda
    @ManyToMany(mappedBy = "servicos")
    private List<Agenda> agendas;

    // Construtores
    public Servico() {}

    public Servico(Long id_servico, String nomeServico, Double preco, String descricaoServico, String tempoServico) {
        this.id_servico = id_servico;
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.descricaoServico = descricaoServico;
        this.tempoServico = tempoServico;
    }

    // Getters e Setters
    public Long getId_servico() {
        return id_servico;
    }

    public void setId_servico(Long id_servico) {
        this.id_servico = id_servico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(String tempoServico) {
        this.tempoServico = tempoServico;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }
}
