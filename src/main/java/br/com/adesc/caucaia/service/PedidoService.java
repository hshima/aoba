package br.com.adesc.caucaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adesc.caucaia.model.Pedido;
import br.com.adesc.caucaia.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repository;
	
	public List<Pedido> getAll() {
		return repository.findAll();
	}

	public Optional<Pedido> findById(Long id) {
		return repository.findById(id);
	}

	public Pedido save(Pedido pedido) {
		return repository.save(pedido);	
	}

}
