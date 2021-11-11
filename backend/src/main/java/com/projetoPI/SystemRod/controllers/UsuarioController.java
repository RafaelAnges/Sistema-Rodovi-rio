package com.projetoPI.SystemRod.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.UsuarioDTO;
import com.projetoPI.SystemRod.entities.Usuario;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.UsuarioRepository;
import com.projetoPI.SystemRod.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> list = usuarioService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioAutenticado = usuarioService.autenticar(usuario.getLogin(), usuario.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		}catch( ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}
	
	@PostMapping
	public ResponseEntity createUsuario(@RequestBody Usuario usuario) {
		
		try {
			
			Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}catch(ResourceNotFoundException e){
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
		
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não existe com id :" + id));
		return ResponseEntity.ok(usuario) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails){
		
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não existe com id :" + id));
		
		usuario.setLogin(usuarioDetails.getLogin());
		usuario.setNome(usuarioDetails.getNome());
		usuario.setCargo(usuarioDetails.getCargo());
		usuario.setEmail(usuarioDetails.getEmail());
		usuario.setSenha(usuarioDetails.getSenha());
		
		Usuario updatedUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Long id){
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não existe com id :" + id));
	
	usuarioRepository.delete(usuario);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
			
	}

}
