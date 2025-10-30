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
@Table(name = "TipoUsuario")
public class TipoUsuario {

	//Atributos(características)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo", nullable = false)
	private Long id_tipo;
	
	@Column(name = "nome_tipo", nullable = false, length = 100)
	private String nome_tipo;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "senha", nullable = false, length = 100)
	private String senha;
	
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> usuario;
	
	//Construtores(método usado para criar objetos)
	
	public TipoUsuario() {
		
	}
	
	public TipoUsuario(Long id_tipo, String nome_tipo, String cpf) {
		this.id_tipo = id_tipo;
		this.nome_tipo = nome_tipo;
		this.cpf = cpf;
	}

	// Getters e Setters(getters -> obtém o valor de um atributo, setters -> altera o valor de um atributo)
	
	public Long getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Long id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNome_tipo() {
		return nome_tipo;
	}

	public void setNome_tipo(String nome_tipo) {
		this.nome_tipo = nome_tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
	