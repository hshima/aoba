package br.com.adesc.caucaia.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor //@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",updatable = false, nullable = false)
	protected Long id;
	protected String nome;
	protected String nomeDoMeio;
	protected String sobrenome;
	@OneToOne
	protected Documento documento;

	@OneToMany
	protected List<Endereco> endereco = new ArrayList<>();

//	protected Pessoa(String nome, String nomeDoMeio, String sobrenome, Documento documento, List<Endereco> endereco) {
//		super();
//		this.nome = nome;
//		this.nomeDoMeio = nomeDoMeio;
//		this.sobrenome = sobrenome;
//		this.documento = documento;
//		this.endereco = endereco;
//	}
	
	public String getNomeCompleto() {
		if(nomeDoMeio == null) return nome + " " + sobrenome; 
		return nome + " " + nomeDoMeio + " " + sobrenome;
	}


}
