package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do tipo de usuário

    @Column(nullable = false, unique = true)
    private String nome; // Nome do tipo de usuário (ex: administrador)

    @Column(nullable = false)
    private String senha; // Senha do usuário (em prod, use hashing)

    // Construtor padrão (necessário para o JPA)
    public TipoUsuario() {
    	
    }
    
    // Construtor completo para criar um TipoUsuario com nome e senha
    public TipoUsuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    // Getters e Setters: métodos para acessar e alterar os atributos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
