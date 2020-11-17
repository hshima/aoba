package br.com.adesc.caucaia.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.adesc.caucaia.model.Produto;
import br.com.adesc.caucaia.model.Produtor;
import br.com.adesc.caucaia.repository.ProdutoRepository;
import lombok.Getter;

@Getter
public class ProdutoToUpdate {
	
	@NotBlank
	@Length(min = 5)
	private String nome;

	@NotNull
	@Length(min = 10)
	private Produtor produtor;
	
	public Produto update(Long id, ProdutoRepository repository) {
		Produto p = repository.getOne(id);
		p.setNome(this.nome);
		p.getProdutores().add(this.produtor);
		return p; 
	}
	
}


