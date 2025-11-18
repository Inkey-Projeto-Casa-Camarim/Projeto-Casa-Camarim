package com.casa_camarim.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDate data;
    
    @Column(nullable = false)
    private LocalTime horario;
    
    @Column(nullable = false)
    private String status = "AGENDADO";
    
    @Column(nullable = false)
    private String telefoneUsuario;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    @JsonBackReference
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    @JsonManagedReference
    private Servico servico;

    
    public Agendamento() {}
    
    // Construtor atualizado
    public Agendamento(LocalDate data, LocalTime horario, Usuario usuario, Servico servico, String telefoneUsuario) {
        this.data = data;
        this.horario = horario;
        this.usuario = usuario;
        this.servico = servico;
        this.telefoneUsuario = telefoneUsuario;
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    
    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getTelefoneUsuario() { return telefoneUsuario; }
    public void setTelefoneUsuario(String telefoneUsuario) { this.telefoneUsuario = telefoneUsuario; }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    
    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }
}