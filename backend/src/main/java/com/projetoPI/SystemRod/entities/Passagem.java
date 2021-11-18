package com.projetoPI.SystemRod.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_passagem")
public class Passagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	
	@Column(name = "cidadeOrigem_p")
	 private String cidadeOrigem;
	
	@Column(name = "valor_p")
	 private Double valor;
	
	@Column(name = "cidadDestino_p")
	 private String cidadeDestino;
	
	@Column(name = "dataSaida_p")
	 private LocalDate dataSaida;
	
	@Column(name = "horaSaida_p")
	 private LocalTime horaSaida;
	
	@Column(name = "veiculo_p")
	 private String veiculo;
	
	@Column(name = "poltrona_p")
	 private Integer poltrona;
	
	public Passagem() {
		
	}

	public Passagem(long id, String cidadeOrigem, Double valor, String cidadeDestino, LocalDate dataSaida,
			LocalTime horaSaida, String veiculo, Integer poltrona) {
		this.id = id;
		this.cidadeOrigem = cidadeOrigem;
		this.valor = valor;
		this.cidadeDestino = cidadeDestino;
		this.dataSaida = dataSaida;
		this.horaSaida = horaSaida;
		this.veiculo = veiculo;
		this.poltrona = poltrona;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(Integer poltrona) {
		this.poltrona = poltrona;
	}
	
	
	
	
}
