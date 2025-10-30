package com.casa_camarim.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda", nullable = false)
    private Long id_agenda;

    @Column(name = "data_agendamento", nullable = false, length = 20)
    private String data;

    @Column(name = "hora_agendamento", nullable = false, length = 20)
    private String hora;

    // 🔗 Relacionamento ManyToMany com Servico
    @ManyToMany
    @JoinTable(
        name = "tb_agenda_servico",
        joinColumns = @JoinColumn(name = "id_agenda"),
        inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    private String servico;
    
    //tabela de cliente
    @ManyToMany
    @JoinTable (
    		name = "tb_usuario",
    		joinColumns= @JoinColumn(name = "id_agenda"), 
    		inverseJoinColumns = @JoinColumn(name = "nome")
    )
    private String cliente;   
    
    private List<Servico> servicos;

    // Construtores
    public Agenda() {}

    public Agenda(Long id_agenda, String data, String hora) {
        this.id_agenda = id_agenda;
        this.data = data;
        this.hora = hora;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
