package br.com.adesc.caucaia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Pessoa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToMany
	private List<Pedido> pedidos = new ArrayList<>();
	
}
