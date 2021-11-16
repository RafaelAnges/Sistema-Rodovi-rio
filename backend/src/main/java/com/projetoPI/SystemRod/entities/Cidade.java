package com.projetoPI.SystemRod.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_c;
	
	@Column(name = "cidade_c")
	private String cidade;
	
	@Column(name = "uf_c")
	private String uf;
	
	
	
	public Cidade() {
		
	}

	public Cidade(Long id_c, String cidade, String uf) {
		this.id_c = id_c;
		this.cidade = cidade;
		this.uf = uf;
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
