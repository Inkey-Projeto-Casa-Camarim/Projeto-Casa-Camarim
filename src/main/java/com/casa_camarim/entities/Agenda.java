package com.casa_camarim.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
public class Agenda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column
    private String observacao;

    public Agenda() {
    	
    }
    
    public Agenda(Usuario usuario, Servico servico, LocalDateTime dataHora, String observacao) {
        this.usuario = usuario;
        this.servico = servico;
        this.dataHora = dataHora;
        this.observacao = observacao;
    }

    // getters e setters
    public Long getId() { 
    	return id;
    	}
    
    public void setId(Long id) {
    	this.id = id;
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
