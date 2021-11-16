package com.projetoPI.SystemRod.dto;

import java.io.Serializable;

import com.projetoPI.SystemRod.entities.Cidade;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id_c;
	private String cidade;
	private String uf;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Long id_c, String cidade, String uf) {
		this.id_c = id_c;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public CidadeDTO(Cidade entity) {
		id_c = entity.getId_c();
		cidade = entity.getCidade();
		uf = entity.getUf();
	}

	public Long getId_c() {
		return id_c;
	}

	public void setId_c(Long id_c) {
		this.id_c = id_c;
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