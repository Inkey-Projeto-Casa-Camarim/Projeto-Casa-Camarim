package com.casa_camarim.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agenda")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agendamento;
    
    @Column(name = "hora", nullable = false)
    private LocalTime hora;
    
    @Column(name = "data", nullable = false)
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="id_servico")
    private Servico servico;
    
    @ManyToOne
    @JoinColumn(name="id_profissional")
    private Profissional profissional;
    
    public Agendamento() {
    	
    }
    
    public Agendamento(Long id_agendamento, LocalTime hora, LocalDate data, Cliente cliente, Servico servico) {
    	this.id_agendamento = id_agendamento;
    	this.hora = hora;
    	this.data = data;
    	this.cliente = cliente;
    	this.servico = servico;
    }

	public Long getId_agendamento() {
		return id_agendamento;
	}

	public void setId_agendamento(Long id_agendamento) {
		this.id_agendamento = id_agendamento;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
