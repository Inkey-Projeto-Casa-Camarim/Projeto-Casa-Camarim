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

// Classe que representa uma entidade (tabela) no banco de dados
@Entity
@Table(name = "tb_agenda")
public class Agendamento {

    // ID: chave primária da tabela, gerada automaticamente pelo banco (auto incremento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agendamento", nullable = false)
    private Long id_agendamento;
    
    @Column(name = "hora_agenda", nullable = false)
    private LocalTime hora;
    
    @Column(name = "data_agenda", nullable = false)
    private LocalDate data;
    
    @Column(name = "cliente_nome", length = 100)
    private String pessoa;
    
    @Column(name = "telefone_cliente", length = 20)
    private String telefone;
    
    @Column(name = "status", length = 20)
    private String status = "AGENDADO";
    
    // Relacionamentos: vários agendamentos podem ter o mesmo cliente, serviço e profissional
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="id_servico")
    private Servico servico;
    
    @ManyToOne
    @JoinColumn(name="id_profissional")
    private Profissional profissional;
    
    // Construtor padrão: usado pelo JPA para criar o objeto sem precisar de parâmetros
    public Agendamento() {
        
    }
    
    // Construtor completo: cria o agendamento com cliente e serviço definidos
    public Agendamento(Long id_agendamento, LocalTime hora, LocalDate data, Cliente cliente, Servico servico) {
        this.id_agendamento = id_agendamento;
        this.hora = hora;
        this.data = data;
        this.cliente = cliente;
        this.servico = servico;
        this.pessoa = cliente.getNome();
        this.telefone = cliente.getTelefone();
    }
    
    // Construtor alternativo: cria o agendamento com dados básicos, sem cliente vinculado
    public Agendamento(LocalTime hora, LocalDate data, Servico servico, String pessoa, String telefone) {
        this.hora = hora;
        this.data = data;
        this.servico = servico;
        this.pessoa = pessoa;
        this.telefone = telefone;
    }

    // Getters e Setters: permitem acessar e modificar os atributos da classe

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
        // Atualiza nome e telefone automaticamente ao definir o cliente
        if(cliente != null) {
            this.pessoa = cliente.getNome();
            this.telefone = cliente.getTelefone();
        }
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}