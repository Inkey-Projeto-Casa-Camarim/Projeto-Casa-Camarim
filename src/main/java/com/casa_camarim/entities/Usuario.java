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
    private Long id; // Identificador único do usuário

    @NotBlank
    @Column(nullable = false)
    private String nome; // Nome do usuário

    @NotBlank
    @Column(nullable = false, unique = true)
    private String telefone; // Telefone do usuário

    // Construtor padrão (necessário para o JPA)
    public Usuario() { }
    
    // Construtor completo para criar um usuário com nome e telefone
    public Usuario(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters: métodos para acessar e alterar os atributos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
