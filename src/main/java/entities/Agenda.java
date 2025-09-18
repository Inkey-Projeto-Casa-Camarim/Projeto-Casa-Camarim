package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agenda")
public class Agenda {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agenda", nullable = false)
	private Long id_agenda;
	
	@Column(name = "data", nullable = false)
	private String data;
	
	// Construtores 
	
	public Agenda() {
		
	}
	
	public Agenda(long id_agenda, String data) {
		this.id_agenda = id_agenda;
		this.data = data;
	}

	// Getters e Setters
	
	public Long getId_agenda() {
		return id_agenda;
	}

	public void setId_agenda(Long id_agenda) {
		this.id_agenda = id_agenda;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
