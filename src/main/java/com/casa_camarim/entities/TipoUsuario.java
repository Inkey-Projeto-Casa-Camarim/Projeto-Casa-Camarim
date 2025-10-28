package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipoUsuario")
public class TipoUsuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoUsuario; // Identificador único do tipo de usuário

    @Column(nullable = false, unique = true)
    private String nome_tipo; // Nome do tipo de usuário (ex: administrador, cliente)

    @Column(nullable = false)
    private String senha; // Senha do usuário (em produção, use hashing)

    @Column(nullable = false, unique = true, length = 11)
    private String cpf; // CPF do usuário (usado para login)

    // Construtores
    public TipoUsuario() {
    }
    
    // Construtor completo para criar um TipoUsuario com todos os campos
    public TipoUsuario(Long id_tipoUsuario, String nome_tipo, String senha, String cpf) {
        this.id_tipoUsuario = id_tipoUsuario;
    	this.nome_tipo = nome_tipo;
        this.senha = senha;
        this.cpf = cpf;
    }

    // Getters e Setters: métodos para acessar e alterar os atributos
	public Long getId_tipoUsuario() {
		return id_tipoUsuario;
	}

	public void setId_tipoUsuario(Long id_tipoUsuario) {
		this.id_tipoUsuario = id_tipoUsuario;
	}

	public String getNome() {
		return nome_tipo;
	}

	public void setNome(String nome) {
		this.nome_tipo = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
