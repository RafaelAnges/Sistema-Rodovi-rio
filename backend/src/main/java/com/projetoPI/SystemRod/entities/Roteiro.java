package com.projetoPI.SystemRod.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_roteiro")
public class Roteiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "cidade_c")
	private String cidade;
	
	
	@Column(name = "modelo_v")
	private String modelo;
	
	
	@Column(name = "poltrona_v")
	private Integer poltrona;
	
	
	public Roteiro() {
		
	}
	
	


	public Roteiro(Long id, String cidade, String modelo, Integer poltrona) {
		this.id = id;
		this.cidade = cidade;
		this.modelo = modelo;
		this.poltrona = poltrona;
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