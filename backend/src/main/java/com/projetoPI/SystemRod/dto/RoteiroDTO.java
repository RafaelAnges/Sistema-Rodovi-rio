package com.projetoPI.SystemRod.dto;

import com.projetoPI.SystemRod.entities.Roteiro;

public class RoteiroDTO {

	private Long id;
	
	private CidadeDTO cidade;
	private VeiculoDTO modelo;
	private VeiculoDTO poltrona;
	
	public RoteiroDTO() {
		
	}

	public RoteiroDTO(Long id, CidadeDTO cidade, VeiculoDTO modelo, VeiculoDTO poltrona) {
		this.id = id;
		this.cidade = cidade;
		this.modelo = modelo;
		this.poltrona = poltrona;
	}
	
	
	public RoteiroDTO(Roteiro entity) {
		id = entity.getId();
		cidade = new CidadeDTO(entity.getCidade());
		modelo = new VeiculoDTO(entity.getModelo());
		poltrona = new VeiculoDTO(entity.getPoltrona());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}

	public VeiculoDTO getModelo() {
		return modelo;
	}

	public void setModelo(VeiculoDTO modelo) {
		this.modelo = modelo;
	}

	public VeiculoDTO getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(VeiculoDTO poltrona) {
		this.poltrona = poltrona;
	}
	
	
	
}
