package com.casa_camarim.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", nullable = false)
	private Long id;

	@Column(name = "nome_cliente", nullable = false, length = 100)
	private String nome;

	@Column(name = "telefone_cliente", nullable = false, length = 11)
	private String telefone;
	
	@Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

	@OneToMany(mappedBy = "cliente")
	private List<Agendamento> agendamentos;

	public Cliente() {
		this.dataCriacao = LocalDateTime.now();
	}

	public Cliente(Long id, String nome, String telefone, List<Agendamento> agendamentos, LocalDateTime dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.agendamentos = agendamentos;
		this.dataCriacao = LocalDateTime.now();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
