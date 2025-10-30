package com.casa_camarim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda", nullable = false)
    private Long id_agenda;

    @Column(name = "nome_cliente", nullable = false, length = 150)
    private String nomeCliente;

    @Column(name = "telefone", nullable = false, length = 30)
    private String telefone;

    @Column(name = "data_agendamento", nullable = false, length = 20)
    private String data; // você pode trocar para LocalDate se preferir tipos de data reais

    @Column(name = "hora_agendamento", nullable = false, length = 20)
    private String hora; // idem — LocalTime seria mais apropriado em produção

    // Construtores
    public Agenda() {
    }

    public Agenda(Long id_agenda, String nomeCliente, String telefone, String data, String hora) {
        this.id_agenda = id_agenda;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
}
