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

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	// Atributos
	
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
	
	// Construtores
	
	public Usuario() {
		
	}

	public Usuario(Long id_usuario, String nome, String telefone, TipoUsuario tipoUsuario) {
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.telefone = telefone;
		this.tipoUsuario = tipoUsuario;
	}

	// Getters e Setters
	
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
}