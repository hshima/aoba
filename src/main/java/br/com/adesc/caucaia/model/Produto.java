package br.com.adesc.caucaia.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	private MedidaContagem medida;
	@ManyToMany(mappedBy = "produtos")
	private List<Produtor> produtores = new ArrayList<>();
	private BigDecimal precoSugerido;
	private BigDecimal precoVenda;
	private BigInteger quantidade;
}
