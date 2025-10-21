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
@Table(name = "tb_agenda")
public class Agenda {

	//Atributos(características)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agenda", nullable = false)
	private Long id_agenda;
	
	@Column(name = "data", nullable = false)
	private String data;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	@JsonIgnoreProperties("usuarios")
	private Usuario usuario;
	
	// Construtores(método usado para criar objetos)
	
	public Agenda() {
	}

		
	public Agenda(Long id_agenda, String data, Usuario usuario) {
		super();
		this.id_agenda = id_agenda;
		this.data = data;
		this.usuario = usuario;
	}

	// Getters e Setters(getters -> obtém o valor de um atributo, setters -> altera o valor de um atributo)

	public Long getId_agenda() {
		return id_agenda;
	}


	public void setId_agenda(Long id_agenda) {
		this.id_agenda = id_agenda;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}