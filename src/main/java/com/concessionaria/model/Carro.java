package com.concessionaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "nome_carro")
	private String nome_carro;
	
	@Column(name = "cor_carro")
	private String cor_carro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_carro() {
		return nome_carro;
	}

	public void setNome_carro(String nome_carro) {
		this.nome_carro = nome_carro;
	}

	public String getCor_carro() {
		return cor_carro;
	}

	public void setCor_carro(String cor_carro) {
		this.cor_carro = cor_carro;
	}

	public Carro() {
	}
	
	
	
}
