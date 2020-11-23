package br.com.adesc.caucaia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable 
@Getter @ToString @EqualsAndHashCode @NoArgsConstructor
public class Precos {

	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	@Setter private BigDecimal precoSugerido;
	@Setter private BigDecimal precoVenda;
	

	public Precos(LocalDate dataInicio, LocalDate dataFim, BigDecimal precoSugerido, BigDecimal precoVenda) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.precoSugerido = precoSugerido;
		this.precoVenda = precoVenda;
	}
}
