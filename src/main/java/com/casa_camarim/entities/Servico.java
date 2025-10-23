package com.casa_camarim.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entidade que representa um Serviço no sistema.
// Na tabela "servico" do banco de dados.
@Entity
@Table(name = "tb_servico")
public class Servico {

	// Atributos -> são as características (ou propriedades) de uma classe.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico", nullable = false)
	private Long id_servico;
	
	@Column(name = "preco", nullable = false, precision = 10, scale = 2)
	private String preco;
	
	@Column(name = "nome_servico", nullable = false)
	private String nome_servico;
	
	@Column(name = "descricao_servico", nullable = false)
	private String descricao;
	
	@Column(name = "tempo_servico", nullable = false)
	private String tempo;
	
	// Construtores -> serve para inicializar os atributos do objeto (ou seja, dar valores iniciais).
	
	public Servico() {
		
	}

	public Servico(Long id_servico, String preco, String nome_servico, String descricao, String tempo, Agenda agenda) {
		super();
		this.id_servico = id_servico;
		this.preco = preco;
		this.nome_servico = nome_servico;
		this.descricao = descricao;
		this.tempo = tempo;
		this.agenda = agenda;
	}
	
	// Getters e Setters -> 
		// Getter: método que retorna (pega) o valor de um atributo.
		// Setter: método que altera (define) o valor de um atributo.

	public Long getId_servico() {
		return id_servico;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getNome_servico() {
		return nome_servico;
	}

	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
}