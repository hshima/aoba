package br.com.adesc.caucaia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adesc.caucaia.model.Produtor;
import br.com.adesc.caucaia.repository.ProdutorRepository;

@Service
public class ProdutorService {
	@Autowired
	ProdutorRepository repository;

	public Optional<Produtor> validateProdutor(Produtor produtor) {
		return repository.findByNomeContaining(produtor.getNome());
	}
	
	
	
}
