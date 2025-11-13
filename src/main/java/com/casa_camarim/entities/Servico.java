package com.casa_camarim.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Classe que representa uma entidade (tabela) no banco de dados
@Entity
@Table(name = "tb_servico")
public class Servico {
	
	// ID: chave primária da tabela, gerada automaticamente pelo banco (auto incremento)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico", nullable = false)
	private Long id_servico;

	@Column(name = "nome_servico", nullable = false)
	private String nome;

	@Column(name = "preco_servico", nullable = false)
	private String preco;
	
	@Column(name = "descricao_servico", length = 255, nullable = false)
    private String descricaoServico;

    @Column(name = "tempo_servico", length = 50, nullable = false)
    private String tempoServico;
	
	@OneToMany(mappedBy = "servico")
	@JsonIgnore
	private List<Agendamento> agendamentos;

	// Construtor padrão: usado pelo JPA para criar instâncias vazias
	public Servico() {}

	// Construtor completo: permite criar o serviço já com todos os atributos definidos
	public Servico(Long id_servico, String nome, String preco, List<Agendamento> agendamentos, String descricaoServico, String tempoServico) {
		this.id_servico = id_servico;
		this.nome = nome;
		this.preco = preco;
		this.agendamentos = agendamentos;
		this.descricaoServico = descricaoServico;
		this.tempoServico = tempoServico;
	}

	// Getters e Setters: permitem acessar e modificar os atributos da classe

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

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
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
}
