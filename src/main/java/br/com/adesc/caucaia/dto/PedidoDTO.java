package br.com.adesc.caucaia.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.adesc.caucaia.model.Cliente;
import br.com.adesc.caucaia.model.Pedido;
import br.com.adesc.caucaia.model.Produto;
import lombok.Data;

@Data
public class PedidoDTO {

	private Long id;
	private Cliente cliente;
	private List<Produto> itens = new ArrayList<>();
	
	public Pedido toPedido(PedidoDTO pedidoDTO) {
		return new Pedido(id, cliente, itens);
	}

	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.cliente = pedido.getCliente();
		this.itens = pedido.getItens();
	}
}
