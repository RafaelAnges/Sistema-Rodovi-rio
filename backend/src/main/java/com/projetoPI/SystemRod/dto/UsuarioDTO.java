package com.projetoPI.SystemRod.dto;

import java.io.Serializable;

import com.projetoPI.SystemRod.entities.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Long id;
	private String login;
	private String nome;
	private String email;
	private String senha;
	private String cargo;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String login, String nome, String email, String senha, String cargo) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
	}
	
	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		login = entity.getLogin();
		nome = entity.getNome();
		email = entity.getEmail();
		senha = entity.getSenha();
		cargo = entity.getCargo();
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
