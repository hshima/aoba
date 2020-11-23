package br.com.adesc.caucaia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	
	@ManyToMany
	private List<Ingrediente> ingredientes = new ArrayList<>();
	
	@Enumerated(EnumType.ORDINAL)
	private MedidaContagem medida = MedidaContagem.NOT_SET;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Produtor produtor;

	@Embedded
	private Precos precos;
	
	private Integer quantidade;
	
	private Boolean deleted = false;

	public Produto(
			String nome, 
			String descricao, 
			String tipo, 
			MedidaContagem medida, 
			Produtor produtor,
			Precos precos,
			Integer quantidade
			) {
		setNome(nome);
		setDescricao(descricao);
		setTipo(tipo);
		setMedida(medida);
		setProdutor(produtor);
		setQuantidade(quantidade);
		setPrecos(precos);
	}

	public Boolean setDeleted() {
		this.deleted = true;
		return this.deleted;
	}

}
