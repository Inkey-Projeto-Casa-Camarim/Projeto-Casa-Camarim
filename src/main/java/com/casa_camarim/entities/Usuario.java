package com.casa_camarim.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Entidade que representa um Usuário no sistema.
//Na tabela "tb_usuario" do banco de dados.
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	// Atributos -> são as características (ou propriedades) de uma classe.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private Long id_usuario;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "telefone", nullable = false, unique = false)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo", nullable = false)
	@JsonIgnoreProperties("usuarios")
	private TipoUsuario tipoUsuario;
	
	@ManyToOne
	@JoinColumn(name = "id_agenda", nullable = false)
	@JsonIgnoreProperties("agendamento")
	private Agenda agenda;
	
	
	
	// Construtores -> serve para inicializar os atributos do objeto (ou seja, dar valores iniciais).
	
	public Usuario() {
		
	}

	public Usuario(Long id_usuario, String nome, String telefone, TipoUsuario tipoUsuario, Agenda agenda) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.telefone = telefone;
		this.tipoUsuario = tipoUsuario;
		this.agenda = agenda;
	}
	

	// Getters e Setters -> 
	// Getter: método que retorna (pega) o valor de um atributo.
	// Setter: método que altera (define) o valor de um atributo.
	

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

}