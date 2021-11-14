package com.projetoPI.SystemRod.dto;

import java.io.Serializable;

import com.projetoPI.SystemRod.entities.Roteiro;

public class RoteiroDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String cidade;
	private String modelo;
	private Integer poltrona;
	
	public RoteiroDTO() {
		
	}

	public RoteiroDTO(Long id, String cidade, String modelo, Integer poltrona) {
		this.id = id;
		this.cidade = cidade;
		this.modelo = modelo;
		this.poltrona = poltrona;
	}
	
	public RoteiroDTO(Roteiro entity) {
		this.id = entity.getId();
		this.cidade = entity.getCidade();
		this.modelo = entity.getModelo();
		this.poltrona = entity.getPoltrona();
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(Integer poltrona) {
		this.poltrona = poltrona;
	}
	
	
	

	
	
	
	
}
