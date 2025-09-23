package Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idServico", nullable = false, unique = false)
	private Long idServico;
	
	@Column(name = "preco", nullable = false, unique = false)
	private Double preco;
	
	@Column(name = "nomeServico", nullable = false, unique = false)
	private String nomeServico;
	
	@OneToMany(mappedBy = "tipoServico")
	private List<Servico> servico;
	
	//Construtores
	
	Servico() {
		
	}
	
	Servico(Long idServico, Double preco, String nomeServico){
		this.idServico = idServico;
		this.preco = preco;
		this.nomeServico = nomeServico;	
	}

	//Getters e Setters
	
	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
}
