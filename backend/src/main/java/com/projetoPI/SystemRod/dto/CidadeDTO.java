package com.projetoPI.SystemRod.dto;

import java.io.Serializable;

import com.projetoPI.SystemRod.entities.Cidade;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cidade;
	private String uf;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Long id, String cidade, String uf) {
		this.id = id;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public CidadeDTO(Cidade entity) {
		id = entity.getId();
		cidade = entity.getCidade();
		uf = entity.getUf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	

}
