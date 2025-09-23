package Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Usuario {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario", nullable = false)
	private Long idUsuario;
	
	@Column(name = "nome", nullable = false, unique = false)
	private String nome;
	
	@Column(name = "telefone", nullable = false, unique = false)
	private String telefone;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "tb_agenda")
	@JsonBackReference
	private Agenda agenda;
	
	//Construtores
	
	public Usuario() {
		
	}
	
	public Usuario(Long idUsuario, String nome, String telefone, String cpf) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	//Getters e Setters
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
