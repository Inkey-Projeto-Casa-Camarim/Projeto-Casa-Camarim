package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo")
public class Tipo {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipo", nullable = false, unique = false)
	private Long idTipo;
	
	@Column(name = "nomeTipo", nullable = false, unique = false)
	private String nomeTipo;
	
	//Construtores
	
	Tipo() {
		
	}
	
	Tipo(Long idTipo, String nomeTipo){
		this.idTipo = idTipo;
		this.nomeTipo = nomeTipo;
	}

	//Getters e Setters
	
	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	
}
