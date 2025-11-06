package com.casa_camarim.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_servico;

	@Column(name = "nome_servico", nullable = false)
	private String nome;

	@Column(name = "preco_servico", nullable = false)
	private String preco;
	
	@OneToMany(mappedBy = "servico")
	private List<Agendamento> agendamentos;

	public Servico() {
		
	}

	public Servico(Long id_servico, String nome, String preco, List<Agendamento> agendamentos) {
		this.id_servico = id_servico;
		this.nome = nome;
		this.preco = preco;
		this.agendamentos = agendamentos;
	}

	public Long getId_servico() {
		return id_servico;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
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

	public void setPreço(String preco) {
		this.preco = preco;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
}
