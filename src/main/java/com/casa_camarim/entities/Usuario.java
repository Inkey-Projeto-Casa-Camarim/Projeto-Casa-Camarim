package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    // 🔹 Relacionamento: Muitos usuários podem ter um mesmo tipo de usuário (ex: cliente, administrador)
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false) // Chave estrangeira que liga ao TipoUsuario
    private TipoUsuario tipoUsuario;

    // Construtor padrão (necessário para o JPA)
    public Usuario() { 
    	
    }
    
    // Construtor completo para criar um usuário com nome, telefone e tipo de usuário
    public Usuario(Long id_usuario, String nome, String telefone, TipoUsuario tipoUsuario) {
        this.id_usuario = id_usuario;
    	this.nome = nome;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
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

    // 🔹 Getters e Setters do relacionamento com TipoUsuario
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
