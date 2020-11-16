package br.com.adesc.caucaia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity @Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class Produtor extends Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Associacao associacao;
	
	@ManyToMany
	private List<Produto> produtos = new ArrayList<>();

	public Produtor(Long id, List<Produto> produtos) {
		super();
		this.id = id;
		this.produtos = produtos;
	}

	public Produtor(String nome, String regiao) {
		setNome(nome);
//		associacao.setRegiao(regiao);
	}
	
	
}
