package com.projetoPI.SystemRod.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_roteiro")
public class Roteiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cidade_c")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name = "modelo_v")
	private Veiculo modelo;
	
	@OneToOne
	@JoinColumn(name = "poltrona_v")
	private Veiculo poltrona;
	
	public Roteiro() {
		
	}

	public Roteiro(Long id, Cidade cidade, Veiculo modelo, Veiculo poltrona) {
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Veiculo getModelo() {
		return modelo;
	}

	public void setModelo(Veiculo modelo) {
		this.modelo = modelo;
	}

	public Veiculo getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(Veiculo poltrona) {
		this.poltrona = poltrona;
	}
	
	

}
