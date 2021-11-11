package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoPI.SystemRod.dto.UsuarioDTO;
import com.projetoPI.SystemRod.entities.Usuario;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario autenticar(String login, String senha) {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
		
		if(!usuario.isPresent()) {
			throw new ResourceNotFoundException("Usuario não encontrado.");
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ResourceNotFoundException("Senha Inválida.");
		}
		
		return usuario.get();
	}
	
	
	public List<UsuarioDTO> findAll(){
		List<Usuario> result = usuarioRepository.findAll();
		return result.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarLogin(usuario.getLogin());
		validar(usuario);
		return usuarioRepository.save(usuario);
	}
	
	
	
	 
	
	public void validarLogin(String login) {
		boolean existe = usuarioRepository.existsByLogin(login);
		if(existe) {
			throw new ResourceNotFoundException("Já existe um usuário cadastrado com este email.");
		}
		
	}
	
	public void validar(Usuario usuario) {
		if(usuario.getNome() == null || usuario.getNome().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um NOME válido.");
		}
		
		if(usuario.getCargo() == null || usuario.getCargo().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um CARGO válido.");
		}
		
		if(usuario.getEmail() == null || usuario.getEmail().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um EMAIL válido.");
		}
		
		if(usuario.getLogin() == null || usuario.getLogin().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um LOGIN válido.");
		}
		
		if(usuario.getSenha() == null || usuario.getSenha().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um SENHA válido.");
		}
	}

}
