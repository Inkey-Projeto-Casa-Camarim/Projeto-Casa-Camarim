package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario; // Identificador único do usuário

    @Column(nullable = false)
    private String nome; // Nome do usuário

    @Column(nullable = false, unique = true)
    private String telefone; // Telefone do usuário

    // Construtor padrão (necessário para o JPA)
    public Usuario() { 
    	
    }
    
    // Construtor completo para criar um usuário com nome e telefone
    public Usuario(Long id_usuario, String nome, String telefone) {
        this.id_usuario = id_usuario;
    	this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters: métodos para acessar e alterar os atributos
    
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
} 