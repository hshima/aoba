package br.com.adesc.caucaia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adesc.caucaia.model.Cliente;
import br.com.adesc.caucaia.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;

	public Optional<Cliente> findByNomeContaining(String nome) {
		return repository.findByNomeContaining(nome);
	}

}
