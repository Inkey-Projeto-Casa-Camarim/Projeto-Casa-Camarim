package com.casa_camarim.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.dto.AuthResponse;
import com.casa_camarim.dto.LoginRequest;
import com.casa_camarim.dto.SignUpRequest;
import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Cliente;
import com.casa_camarim.service.AgendamentoService;
import com.casa_camarim.service.ClienteService;

@RestController
@RequestMapping("/api/cliente") // Define o endpoint principal do controller
@CrossOrigin(origins = "*") // Permite que o front-end acesse essa API
public class ClienteController {
	
	// Injeta automaticamente o service do Cliente
	@Autowired
	private ClienteService clienteService;
	
	// Injeta o service de Agendamento (usado para buscar agendamentos do cliente)
	@Autowired
	private AgendamentoService agendamentoService;

	// Registro
	@PostMapping("/registro")
	public ResponseEntity<AuthResponse> registrarCliente(@RequestBody SignUpRequest request) {
	    try {
	        // Validação de campos obrigatórios
	        if (request.getNome() == null || request.getNome().trim().isEmpty()) {
	            return ResponseEntity.badRequest().body(new AuthResponse(false, "Nome é obrigatório"));
	        }
	        
	        if (request.getTelefone() == null || request.getTelefone().trim().isEmpty()) {
	            return ResponseEntity.badRequest().body(new AuthResponse(false, "Telefone é obrigatório"));
	        }
	        
	        // Verifica se já existe um cliente com o mesmo telefone
	        if (clienteService.existsByTelefone(request.getTelefone())) {
	            return ResponseEntity.badRequest().body(new AuthResponse(false, "Telefone já cadastrado"));
	        }
	        
	        // Cria um novo cliente
	        Cliente novoCliente = clienteService.criarCliente(
	            request.getNome(),
	            request.getTelefone()
	        );
	        
	        return ResponseEntity.ok().body(new AuthResponse(true, "Usuário registrado com sucesso", novoCliente));
	        
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(new AuthResponse(false, "Erro no registro: " + e.getMessage()));
	    }
	}

	// Login
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
	    try {
	    	Cliente cliente = clienteService.login(request.getTelefone(), request.getNome());
	        
	        if (cliente != null) {
	            return ResponseEntity.ok().body(new AuthResponse(true, "Login realizado com sucesso", cliente));
	        } else {
	            return ResponseEntity.status(401).body(new AuthResponse(false, "Credenciais inválidas"));
	        }
	        
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(new AuthResponse(false, "Erro no login: " + e.getMessage()));
	    }
	}

	//Agendamentos do cliente
	@GetMapping("/{usuarioId}/agendamentos")
	public ResponseEntity<List<Agendamento>> getAgendamentosCliente(@PathVariable Long clienteId) {
	    List<Agendamento> agendamentos = agendamentoService.getAgendamentosByClienteId(clienteId);
	    return ResponseEntity.ok(agendamentos);
	}

	//Buscar cliente por ID
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
	    Optional<Cliente> cliente = clienteService.getClienteById(id);
	    return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	//Listar todos
	@GetMapping
	public List<Cliente> getAllCliente() {
	    return clienteService.getAllClientes();
	}

	//Atualizar cliente
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
	    Optional<Cliente> clienteExistente = clienteService.getClienteById(id);
	    
	    if (clienteExistente.isPresent()) {
	        cliente.setId(id);
	        Cliente clienteAtualizado = clienteService.saveCliente(cliente);
	        return ResponseEntity.ok(clienteAtualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	// Deletar cliente
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
	    if (clienteService.getClienteById(id).isPresent()) {
	        clienteService.deleteCliente(id);
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
