package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoUsuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo", nullable = false)
	private Long id_tipo;
	
	@Column(name = "nome_tipo", nullable = false, length = 100)
	private String nome_tipo;
	
	public TipoUsuario() {
		
	}
	
	public TipoUsuario(Long id_tipo, String nome_tipo) {
		this.id_tipo = id_tipo;
		this.nome_tipo = nome_tipo;
	}

	// Getters e Setters
	
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
	
}
