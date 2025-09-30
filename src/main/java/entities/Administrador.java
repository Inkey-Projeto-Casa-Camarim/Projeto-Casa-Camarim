package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_administrador")
public class Administrador {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_administrador", nullable = false)
	private Long id_administrador;
	
	@Column(name = "cpfAdm", nullable = false)
	private String cpfAdm;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	//Construtores
	
	public Administrador() {
		
	}
	
	public Administrador(long id_administrador, String cpfAdm, String senha) {
		this.id_administrador = id_administrador;
		this.cpfAdm = cpfAdm;
		this.senha = senha;
	}

	//Getters e Setters
	
	public Long getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(Long id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getCpfAdm() {
		return cpfAdm;
	}

	public void setCpfAdm(String cpfAdm) {
		this.cpfAdm = cpfAdm;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
