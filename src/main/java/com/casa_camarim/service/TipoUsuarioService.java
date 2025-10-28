package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    // Salvar um novo tipo de usuário (ex: administrador)
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    // Listar todos os tipos de usuário
    public List<TipoUsuario> listarTodos() {
        return tipoUsuarioRepository.findAll();
    }

    // Buscar um tipo de usuário pelo ID
    public Optional<TipoUsuario> buscarPorId(Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    // Buscar um tipo de usuário pelo nome
    public Optional<TipoUsuario> buscarPorNome(String nome) {
        return tipoUsuarioRepository.findByNome(nome);
    }

    // Deletar um tipo de usuário
    public void deletar(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }

    // Validar login do administrador
    public boolean validarLogin(String nome, String senha) {
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findByNome(nome);
        return tipoUsuario.isPresent() && tipoUsuario.get().getSenha().equals(senha);
    }
}
