package br.com.adesc.caucaia.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import lombok.Data;

@Data 
public abstract class Pessoa {

	private String nome;
	private String nomeDoMeio;
	private String sobrenome;
	private Documento documento;

	@ManyToOne
	private List<Endereco> endereco = new ArrayList<>();
	
	public String getNomeCompleto() {
		if(nomeDoMeio == null) return nome + " " + sobrenome; 
		return nome + " " + nomeDoMeio + " " + sobrenome;
	}
}
