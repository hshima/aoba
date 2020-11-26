package br.com.adesc.caucaia.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adesc.caucaia.dto.PedidoDTO;
import br.com.adesc.caucaia.event.CreateResourceEvent;
import br.com.adesc.caucaia.model.Cliente;
import br.com.adesc.caucaia.model.Pedido;
import br.com.adesc.caucaia.service.ClienteService;
import br.com.adesc.caucaia.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;
	
	@Autowired
	ClienteService clienteService;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listAll(){
		List<Pedido> list = service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("id")
	public ResponseEntity<Pedido> listOne(@PathVariable Long id){
		Optional<Pedido> optional = service.findById(id);
		if(optional.isPresent()) ResponseEntity.ok(optional.get());
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PedidoDTO> createPedido(
			@RequestBody PedidoDTO pedidoDTO,
			HttpServletResponse response
			){
		Pedido pedido = pedidoDTO.toPedido(pedidoDTO);
		
		
		Cliente cliente = pedido.getCliente();
		Optional<Cliente> optional = clienteService.findByNomeContaining(cliente.getNome());
		if(optional.isPresent())
			pedido.setCliente(optional.get());
		
		Pedido p = service.save(pedido);
		
		Long id = p.getId();
		publisher.publishEvent(new CreateResourceEvent(this, response, id));	
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new PedidoDTO(pedido));
	}
}
