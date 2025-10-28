package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String telefone; // sugerido formato: +55DDDNNNNNNN

    public Usuario() {
    	
    }
    
    public Usuario(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
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

    public String getTelefone() {
    	return telefone;
    	}
    
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    	}
}
