package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.SystemRod.dto.UsuarioDTO;
import com.projetoPI.SystemRod.entities.Usuario;
import com.projetoPI.SystemRod.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<UsuarioDTO> findAll(){
		List<Usuario> result = usuarioRepository.findAll();
		return result.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}

}
