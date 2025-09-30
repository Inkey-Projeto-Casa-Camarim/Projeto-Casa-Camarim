package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico", nullable = false)
	private Long id_servico;
	
	@Column(name = "preco", nullable = false)
	private Double preco;
	
	@Column(name = "nome_servico", nullable = false)
	private String nome_servico;
	
	// Construtores
	
	public Servico() {
		
	}
	
	public Servico(Long id_servico, Double preco, String nome_servico) {
		this.id_servico = id_servico;
		this.nome_servico = nome_servico;
		this.preco = preco;
	}

	// Getters e Setters
	
	public Long getId_servico() {
		return id_servico;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNome_servico() {
		return nome_servico;
	}

	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}
	
}
