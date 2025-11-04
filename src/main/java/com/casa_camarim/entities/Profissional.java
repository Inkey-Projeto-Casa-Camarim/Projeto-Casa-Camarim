package com.casa_camarim.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_profissional;

	private String cpf;
	
	private String telefone;
	
	private String senha;
	
	private String nome;

	private String especialidade;
	
	@OneToMany(mappedBy = "profissional")
	private List<Agendamento> agendamentos;
	
	public Profissional() {
		
	}

	public Profissional(Long id_profissional, String nome, String especialidade, List<Agendamento> agendamentos) {
		this.id_profissional = id_profissional;
		this.nome = nome;
		this.especialidade = especialidade;
		this.agendamentos = agendamentos;
	}
	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Long getId_profissional() {
		return id_profissional;
	}

	public void setId_profissional(Long id_profissional) {
		this.id_profissional = id_profissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Agendamento> getAgendamento() {
		return agendamentos;
	}

	public void setAgendamento(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	
	

}
