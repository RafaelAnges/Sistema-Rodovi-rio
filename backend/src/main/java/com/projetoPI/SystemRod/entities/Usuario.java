package com.projetoPI.SystemRod.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "login_u")
	private String login;
	
	@Column(name = "nome_u")
	private String nome;
	
	@Column(name = "email_u")
	private String email;
	
	@Column(name = "senha_u")
	private String senha;
	
	@Column(name = "cargo_u")
	private String cargo;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String login, String nome, String email, String senha, String cargo) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
	

}
