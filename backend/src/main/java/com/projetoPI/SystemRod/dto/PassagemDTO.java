package com.projetoPI.SystemRod.dto;

import java.io.Serializable;
import java.time.LocalTime;

import com.projetoPI.SystemRod.entities.Passagem;

public class PassagemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
     private long id;
	 private String cidadeOrigem;
	 private Double valor;
	 private String cidadeDestino;
	 private String email;
	 private String name;
	 private LocalTime horaSaida;
	 private String veiculo;
	 private Integer poltrona;
	 
	 public PassagemDTO() {
		 
	 }

	public PassagemDTO(long id, String cidadeOrigem, Double valor, String cidadeDestino, 
			String email, String  name,
			LocalTime horaSaida, String veiculo, Integer poltrona) {
		this.id = id;
		this.cidadeOrigem = cidadeOrigem;
		this.valor = valor;
		this.cidadeDestino = cidadeDestino;
		this.email = email;
		this.name = name;
		this.horaSaida = horaSaida;
		this.veiculo = veiculo;
		this.poltrona = poltrona;
		
	}
	
	public PassagemDTO(Passagem entity) {
		this.id = entity.getId();
		this.cidadeOrigem = entity.getCidadeOrigem();
		this.valor = entity.getValor();
		this.cidadeDestino = entity.getCidadeDestino();
		this.email = entity.getEmail();
		this.name = entity.getName();
		this.horaSaida = entity.getHoraSaida();
		this.veiculo = entity.getVeiculo();
		this.poltrona = entity.getPoltrona();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
