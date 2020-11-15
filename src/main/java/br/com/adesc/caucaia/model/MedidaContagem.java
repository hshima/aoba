package br.com.adesc.caucaia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum MedidaContagem {
	BANDEJA("Bandeja"),
	UNIDADE("Unidade"),
	PORCAO("Porção"),
	GRANDE("Grande"),
	MEDIO("Médio"),
	PEQUENO("Pequeno"),
	PACOTE("Pacote"),
	KG("Kilograma"),
	L("Litro"),
	MACO("Maço");

	private String medida;
	
}
