package br.com.adesc.caucaia.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.adesc.caucaia.model.MedidaContagem;
import br.com.adesc.caucaia.model.Produto;
import br.com.adesc.caucaia.model.Produtor;
import lombok.Data;

@Data
public class ProdutoDTO {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	private MedidaContagem medida;
	@ManyToMany(mappedBy = "produtos")
	private List<Produtor> produtores = new ArrayList<>();
	private BigDecimal precoSugerido;
	private BigDecimal precoVenda;
	private Integer quantidade;
	
	public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.tipo = produto.getTipo();
		this.medida = produto.getMedida();
		this.produtores = produto.getProdutores();
		this.precoSugerido = produto.getPrecoSugerido();
		this.precoVenda = produto.getPrecoVenda();
		this.quantidade = produto.getQuantidade();
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream()
				.map(ProdutoDTO::new)
				.collect(Collectors.toList());
	}
}
