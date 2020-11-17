package br.com.adesc.caucaia.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.adesc.caucaia.controller.dto.ProdutoToUpdate;
import br.com.adesc.caucaia.dto.ProdutoDTO;
import br.com.adesc.caucaia.model.Produto;
import br.com.adesc.caucaia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDTO> showMenu(String menu) {
		List<Produto> produtos = new ArrayList<>();
		if (menu == null) {
			produtos = produtoRepository.findAll();
		} else {
			produtos = produtoRepository.findByNomeContaining(menu);
		}
		return ProdutoDTO.listConverter(produtos);
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> listChosen(@PathVariable Long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDTO> createPedido(
			@RequestBody @Valid ProdutoDTO produtoDTO,
			UriComponentsBuilder uriBuilder
			){
		
		Produto produto = produtoDTO.toProduto(produtoRepository);
		produtoRepository.save(produto);
		URI uri = uriBuilder
				.path("/produto/{id}")
				.buildAndExpand(produto.getId())
				.toUri(); 
		return ResponseEntity
				.created(uri)
				.body(new ProdutoDTO(produto));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDTO> update(
			@PathVariable Long id, 
			@RequestBody @Valid ProdutoToUpdate produtoToUpdate 
			){
		
		Optional<Produto> optional = produtoRepository.findById(id);
		
		if(optional.isPresent()) {
			Produto produto = produtoToUpdate.update(id, produtoRepository);
			return ResponseEntity
					.ok(new ProdutoDTO(produto));
		}
		
		return ResponseEntity
					.notFound()
					.build();
	}
	
}
