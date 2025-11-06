package com.casa_camarim.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profissional")
public class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_profissional;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "telefone_profissional", nullable = false, length = 11)
	private String telefone;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "nome_profissional", nullable = false)
	private String nome;

	@Column(name = "especialidade", nullable = false)
	private String especialidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_acesso", nullable = false)
	private TipoAcesso tipoacesso = TipoAcesso.Comum;
	
	@OneToMany(mappedBy = "profissional")
	private List<Agendamento> agendamentos;
	
	
	public Profissional() {
		
	}


	public Profissional(Long id_profissional, String cpf, String telefone, String senha, String nome,
			String especialidade, TipoAcesso tipoacesso, List<Agendamento> agendamentos) {
		super();
		this.id_profissional = id_profissional;
		this.cpf = cpf;
		this.telefone = telefone;
		this.senha = senha;
		this.nome = nome;
		this.especialidade = especialidade;
		this.tipoacesso = tipoacesso;
		this.agendamentos = agendamentos;
	}


	public Long getId_profissional() {
		return id_profissional;
	}


	public void setId_profissional(Long id_profissional) {
		this.id_profissional = id_profissional;
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


	public TipoAcesso getTipoacesso() {
		return tipoacesso;
	}


	public void setTipoacesso(TipoAcesso tipoacesso) {
		this.tipoacesso = tipoacesso;
	}


	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}


	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
}
