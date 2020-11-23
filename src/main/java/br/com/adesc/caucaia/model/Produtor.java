package br.com.adesc.caucaia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity @Data @EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id") @JsonIgnoreProperties({"produtos"})
public class Produtor extends Pessoa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Associacao associacao;

	@OneToMany(mappedBy = "produtor")
	private List<Produto> produtos = new ArrayList<>();

	public Produtor(Long id, List<Produto> produtos) {
		super();
		this.id = id;
		this.produtos = produtos;
	}

	public Produtor(String nome) {
		setNome(nome);
	}

	public Produtor(String nomeProdutor, Associacao associacao) {
		this.setNome(nomeProdutor);
		this.associacao = associacao;
	}

	public Produtor(Associacao associacao, Long id, String nome, String nomeDoMeio, String sobrenome,
			Documento documento, List<Endereco> endereco) {
		this.associacao = associacao;
		this.id = id;
		this.nome = nome;
		this.nomeDoMeio = nomeDoMeio;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;

	}

}
