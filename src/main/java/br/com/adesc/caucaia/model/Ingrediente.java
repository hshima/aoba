package br.com.adesc.caucaia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class Ingrediente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ingrediente;
}
