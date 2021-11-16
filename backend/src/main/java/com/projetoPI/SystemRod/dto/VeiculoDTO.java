package com.projetoPI.SystemRod.dto;

import java.io.Serializable;
import java.time.LocalDate;


import com.projetoPI.SystemRod.entities.Veiculo;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id_v;
	private LocalDate dataCompra;
	private String placa;
	private String motorista;
	private String modelo;
	private Integer poltrona;
	
	public VeiculoDTO() {
		
	}

	public VeiculoDTO(Long id_v, LocalDate dataCompra, String placa, String motorista, String modelo, Integer poltrona) {
		this.id_v = id_v;
		this.dataCompra = dataCompra;
		this.placa = placa;
		this.motorista = motorista;
		this.modelo = modelo;
		this.poltrona = poltrona;
	}
	
	public VeiculoDTO(Veiculo entity) {
		id_v = entity.getId_v();
		dataCompra = entity.getDataCompra();
		placa = entity.getPlaca();
		motorista = entity.getMotorista();
		modelo = entity.getModelo();
		poltrona = entity.getPoltrona();
	}

	public Long getId_v() {
		return id_v;
	}

	public void setId_v(Long id_v) {
		this.id_v = id_v;
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