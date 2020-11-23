package br.com.adesc.caucaia.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adesc.caucaia.model.MedidaContagem;
import br.com.adesc.caucaia.model.Precos;
import br.com.adesc.caucaia.model.Produto;
import br.com.adesc.caucaia.model.Produtor;
import br.com.adesc.caucaia.repository.ProdutoRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	private MedidaContagem medida;
	private Produtor produtor;
	private Precos precos;
	private Integer quantidade;
	
	public ProdutoDTO(Produto produto) {
        
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.tipo = produto.getTipo();
		this.medida = produto.getMedida();
		this.produtor = produto.getProdutor();
		this.precos = produto.getPrecos();
		this.quantidade = produto.getQuantidade();
	}

	public static List<ProdutoDTO> listConverter(List<Produto> produtos) {
		return produtos.stream()
				.map(ProdutoDTO::new)
				.collect(Collectors.toList());
	}

	public Produto toProduto() {
		return new Produto(nome, descricao, tipo, medida, produtor, precos, quantidade);
	}

	public Produto update(Long id, ProdutoRepository repository) {
		Produto p = repository.getOne(id);
		if(!this.nome.equals(p.getNome()) && !this.nome.isBlank()) 
			p.setNome(this.nome);
		if(!this.descricao.equals(p.getDescricao()) && !this.descricao.isBlank()) 
			p.setDescricao(this.descricao);
		if(!this.tipo.equals(p.getTipo()) && !this.tipo.isBlank()) 
			p.setTipo(this.tipo);
		if(!this.medida.equals(p.getMedida()) && this.medida != null) 
			p.setMedida(this.medida);
		if(!this.produtor.equals(p.getProdutor()) && this.produtor != null) 
			p.setProdutor(this.produtor);
		if(!this.precos.equals(p.getPrecos()) && this.precos != null) 
			p.setPrecos(this.precos);
		if(!this.quantidade.equals(p.getQuantidade()) && this.quantidade != null) 
			p.setQuantidade(this.quantidade);
		repository.save(p);
		return repository.getOne(id);
	}

}
