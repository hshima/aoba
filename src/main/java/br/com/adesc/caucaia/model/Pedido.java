package br.com.adesc.caucaia.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity @Data
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToMany
	private List<Produto> itens = new ArrayList<>();
	
	public BigDecimal trazerTotal() {
		BigDecimal total = new BigDecimal(0.00);
		itens.forEach(produto -> total.add(produto.getPrecoVenda()));
		return total;
	}
}
