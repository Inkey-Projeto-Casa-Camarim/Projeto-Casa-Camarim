package Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agenda")
public class Agenda {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAgenda", nullable = false, unique = false)
	private Long idAgenda;
	
	@Column(name = "dia", nullable = false, unique = false)
	private String dia;
	
	@Column(name = "horario", nullable = false, unique = false)
	private String horario;
	
	@ManyToOne
	@JoinColumn(name = "tb_servico")
	@JsonBackReference
	private Servico servico;
	
	@OneToMany(mappedBy = "tipoAgenda")
	private List<Agenda> agenda;
	
	//Construtores
	
	Agenda() {
		
	}
	
	Agenda(Long idAgenda, String dia, String horario) {
		this.idAgenda= idAgenda;
		this.dia = dia;
		this.horario = horario;
	}

	//Getters e Setters
	
	public Long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
