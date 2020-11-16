package br.com.adesc.caucaia.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adesc.caucaia.dto.ProdutoDTO;
import br.com.adesc.caucaia.model.MedidaContagem;
import br.com.adesc.caucaia.model.Produto;
import br.com.adesc.caucaia.repository.ProdutoRepository;

@RestController
@RequestMapping("/")
public class HomeController {
	
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
		
		return ProdutoDTO.converter(produtos);
	}
}
