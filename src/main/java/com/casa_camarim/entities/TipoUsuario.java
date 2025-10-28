package com.casa_camarim.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // ex: administrador

    @Column(nullable = false)
    private String senha; // exemplo simples: texto plano. Em prod, use hashing.

    public TipoUsuario() {
    	
    }
    
    public TipoUsuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    // getters e setters
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

    public String getSenha() {
    	return senha;
    	}
    
    public void setSenha(String senha) {
    	this.senha = senha;
    	}
}
