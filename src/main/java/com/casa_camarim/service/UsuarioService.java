package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.entities.Usuario;
import com.casa_camarim.repositories.TipoUsuarioRepository;
import com.casa_camarim.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    // Salva ou atualiza um usuário no banco de dados.
    public Usuario saveUsuario(Usuario usuario) {
        // Garante que o usuário tenha um tipo associado
        if (usuario.getTipoUsuario() == null) {
            TipoUsuario cliente = tipoUsuarioRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Tipo de usuário padrão (ID=1) não encontrado!"));
            usuario.setTipoUsuario(cliente);
        }

        return usuarioRepository.save(usuario);
    }

    // Retorna todos os usuários cadastrados.
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    // Busca um usuário pelo seu ID.
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    // Exclui um usuário pelo ID.
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Busca o usuário pelo telefone.
    public Usuario getUsuarioByTelefone(String telefone) {
        return usuarioRepository.findByTelefone(telefone)
                .orElse(null); // ou .orElseThrow(...) se preferir lançar erro
    }
}
