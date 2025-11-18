package com.casa_camarim.service;

import com.casa_camarim.entities.Usuario;
import com.casa_camarim.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar usuário
    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByTelefone(usuario.getTelefone())) {
            throw new RuntimeException("Telefone já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    // Login
    public Usuario login(String telefone, String senha) {
        return usuarioRepository.findByTelefoneAndSenha(telefone, senha)
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
    }

    // Buscar por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Buscar por telefone
    public Optional<Usuario> buscarPorTelefone(String telefone) {
        return usuarioRepository.findByTelefone(telefone);
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Atualizar usuário
    public Usuario atualizarUsuario(Long id, Usuario dadosAtualizados) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Evitar duplicidade de telefone
        if (!usuarioExistente.getTelefone().equals(dadosAtualizados.getTelefone()) &&
                usuarioRepository.existsByTelefone(dadosAtualizados.getTelefone())) {
            throw new RuntimeException("Telefone já cadastrado");
        }

        usuarioExistente.setNome(dadosAtualizados.getNome());
        usuarioExistente.setTelefone(dadosAtualizados.getTelefone());
        usuarioExistente.setSenha(dadosAtualizados.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    // Deletar usuário por ID
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
