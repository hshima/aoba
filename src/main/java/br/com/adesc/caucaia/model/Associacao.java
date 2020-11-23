package br.com.adesc.caucaia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class Associacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "id")
	List<Produtor> produtores = new ArrayList<>();
	private String regiao;
	
	

	public Associacao(String regiao) {
		this.regiao = regiao;
	}
}
