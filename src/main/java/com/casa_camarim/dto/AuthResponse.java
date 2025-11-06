package com.casa_camarim.dto;

import com.casa_camarim.entities.Cliente;

public class AuthResponse {
    private boolean success;
    private String message;
    private Cliente cliente;
    
    public AuthResponse() {}
    
    public AuthResponse(boolean success, String message, Cliente cliente) {
        this.success = success;
        this.message = message;
        this.cliente = cliente;
    }
    
    public AuthResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}