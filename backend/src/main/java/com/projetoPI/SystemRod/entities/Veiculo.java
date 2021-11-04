package com.projetoPI.SystemRod.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dataCompra_v")
	private LocalDate dataCompra;
	
	@Column(name = "placa_v")
	private String placa;
	
	@Column(name = "motorista_v")
	private String motorista;
	
	@Column(name = "modelo_v")
	private String modelo;
	
	@Column(name = "poltrona_v")
	private Integer poltrona;
	
	public Veiculo() {
		
	}

	public Veiculo(Long id, LocalDate dataCompra, String placa, String motorista, String modelo, Integer poltrona) {
		this.id = id;
		this.dataCompra = dataCompra;
		this.placa = placa;
		this.motorista = motorista;
		this.modelo = modelo;
		this.poltrona = poltrona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
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
