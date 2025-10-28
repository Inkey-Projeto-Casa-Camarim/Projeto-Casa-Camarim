package com.casa_camarim.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "servicos")
public class Servico {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do serviço

    @NotBlank
    @Column(nullable = false)
    private String nome; // Nome do serviço

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco; // Preço do serviço

    @Column(nullable = false)
    private Integer tempoMinutos; // Duração do serviço em minutos

    // Construtor padrão (necessário para o JPA)
    public Servico() { }
    
    // Construtor completo para criar um serviço com todos os atributos
    public Servico(String nome, BigDecimal preco, Integer tempoMinutos) {
        this.nome = nome;
        this.preco = preco;
        this.tempoMinutos = tempoMinutos;
    }

    // Getters e Setters: métodos para acessar e alterar os atributos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getTempoMinutos() { return tempoMinutos; }
    public void setTempoMinutos(Integer tempoMinutos) { this.tempoMinutos = tempoMinutos; }
}
