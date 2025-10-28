package com.casa_camarim.dto;

public class AgendaAdminDto {
	
    public Long id;
    public String cliente;
    public String telefone;
    public String servico;
    public String dataHora;
    public String whatsappLink;

    public AgendaAdminDto(Long id, String cliente, String telefone, String servico, String dataHora, String whatsappLink) {
        this.id = id;
        this.cliente = cliente;
        this.telefone = telefone;
        this.servico = servico;
        this.dataHora = dataHora;
        this.whatsappLink = whatsappLink;
    }
}

