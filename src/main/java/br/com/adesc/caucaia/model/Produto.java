package br.com.adesc.caucaia.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity @Data
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	@ManyToMany
	private List<Ingrediente> ingrediente = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private MedidaContagem medida = MedidaContagem.NOT_SET;
	@ManyToMany(mappedBy = "produtos")
	private List<Produtor> produtores = new ArrayList<>();
	private BigDecimal precoSugerido;
	private BigDecimal precoVenda;
	private Integer quantidade;
	
	
	public Produto(String nomeProduto, String tipo, MedidaContagem medida, String nomeProdutor, String regiao, BigDecimal precoVenda, Integer quantidade) {
		super();
		this.nome = nomeProduto;
		this.tipo = tipo;
		this.medida = medida;
		this.produtores.add(new Produtor(nomeProdutor, regiao));
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
	}

}
