package br.com.adesc.caucaia.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.adesc.caucaia.dto.ProdutoDTO;
import br.com.adesc.caucaia.model.Produto;
import br.com.adesc.caucaia.model.Produtor;
import br.com.adesc.caucaia.repository.ProdutoRepository;
import br.com.adesc.caucaia.service.ProdutorService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ProdutorService produtorService;
	
	@GetMapping
	public List<ProdutoDTO> showMenu(String menu) {
		List<Produto> produtos = new ArrayList<>();
		if (menu == null) {
			produtos = produtoRepository.findByDeletedNot(true);
		} else {
			System.out.println("GetMapping Sem argumentos");
			Optional<List<Produto>> optional = produtoRepository.findByNomeContaining(menu);
			if (optional.isPresent()) {
				produtos = optional.get(); 
			}
		}
		return ProdutoDTO.listConverter(produtos);
	}
	
	@GetMapping("/{id}") @Transactional
	public ResponseEntity<ProdutoDTO> listChosen(@PathVariable Long id) {
		Produto p = produtoRepository.findById(id).get();
		if(p.getDeleted()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(new ProdutoDTO(p));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDTO> createProduto(
			@RequestBody @Valid ProdutoDTO produtoDTO,
			UriComponentsBuilder uriBuilder
			){
		
		Produto produto = produtoDTO.toProduto();
		Optional<Produtor> optional = produtorService.validateProdutor(produto.getProdutor());
		if(optional.isPresent()) produto.setProdutor(optional.get());
		
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
//			@RequestBody @Valid ProdutoToUpdate produtoToUpdate 
			@RequestBody @Valid ProdutoDTO produtoToUpdate
			){
		
		Optional<Produto> optional = produtoRepository.findById(id);
		
		if(optional.isPresent()) {
			Produto produto = produtoToUpdate.update(id, produtoRepository);
			//TODO Implement update
			
			return ResponseEntity
					.ok(new ProdutoDTO(produto));
		}
		
		return ResponseEntity
					.notFound()
					.build();
	} 
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Produto> delete(@PathVariable Long id){
		
		Produto p = produtoRepository.getOne(id);
		if(p.setDeleted()) {
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.notFound().build();
	}
}
