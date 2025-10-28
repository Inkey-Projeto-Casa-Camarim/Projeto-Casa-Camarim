package com.casa_camarim.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda; // Identificador único da agenda

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // Usuário associado à agenda

    @ManyToOne(optional = false)
    @JoinColumn(name = "servico_id")
    private Servico servico; // Serviço agendado

    @Column(nullable = false)
    private LocalDateTime dataHora; // Data e hora do agendamento

    @Column
    private String observacao; // Observações adicionais do agendamento

    // Construtor padrão (necessário para o JPA)
    public Agenda() { 
    
    }

    // Construtor completo para criar uma agenda com todos os atributos
    public Agenda(Long id_agenda, Usuario usuario, Servico servico, LocalDateTime dataHora, String observacao) {
        this.id_agenda = id_agenda;
    	this.usuario = usuario;
        this.servico = servico;
        this.dataHora = dataHora;
        this.observacao = observacao;
    }
    
    // Getters e Setters: métodos para acessar e alterar os atributos

	public Long getId_agenda() {
		return id_agenda;
	}

	public void setId_agenda(Long id_agenda) {
		this.id_agenda = id_agenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}