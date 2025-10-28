package com.casa_camarim.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AgendaRequest {
	
    @NotNull
    private Long servicoId;

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String telefone;

    @NotBlank
    private String dataHora; // ISO-8601 string: 2025-10-29T14:30

    private String observacao;

    // getters e setters
    public Long getServicoId() {
    	return servicoId;
    	}
    
    public void setServicoId(Long servicoId) {
    	this.servicoId = servicoId;
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

    public String getDataHora() {
    	return dataHora;
    	}
    
    public void setDataHora(String dataHora) {
    	this.dataHora = dataHora;
    	}

    public String getObservacao() {
    	return observacao;
    	}
    
    public void setObservacao(String observacao) {
    	this.observacao = observacao;
    	}
}
