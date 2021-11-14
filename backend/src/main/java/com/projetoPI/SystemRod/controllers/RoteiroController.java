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

import com.projetoPI.SystemRod.dto.RoteiroDTO;
import com.projetoPI.SystemRod.entities.Roteiro;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.RoteiroRepository;
import com.projetoPI.SystemRod.service.RoteiroService;

@RestController
@RequestMapping("/api/v1/roteiros")
public class RoteiroController {
	
	@Autowired
	private RoteiroService roteiroService;
	
	@Autowired
	private RoteiroRepository roteiroRepository;
	
	@GetMapping
	public ResponseEntity<List<RoteiroDTO>> findAll() {
		List<RoteiroDTO> list = roteiroService.findAll();
		return ResponseEntity.ok(list);

}
	
	
	
	@PostMapping
	public ResponseEntity createRoteiro(@RequestBody Roteiro roteiro) {
		
		try {
			
			Roteiro roteiroSalvo = roteiroService.salvarRoteiro(roteiro);
			return new ResponseEntity(roteiroSalvo, HttpStatus.CREATED);
		}catch(ResourceNotFoundException e){
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Roteiro> getRoteiroById(@PathVariable Long id) {
		
		Roteiro roteiro = roteiroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Roteiro não existe com id :" + id));
		return ResponseEntity.ok(roteiro) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Roteiro> updateRoteiro(@PathVariable Long id, @RequestBody Roteiro roteiroDetails){
		
		Roteiro roteiro = roteiroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Roteiro não existe com id :" + id));
		
		roteiro.setCidade(roteiroDetails.getCidade());
		roteiro.setModelo(roteiroDetails.getModelo());
		roteiro.setPoltrona(roteiroDetails.getPoltrona());
		
		Roteiro updatedRoteiro = roteiroRepository.save(roteiro);
		return ResponseEntity.ok(updatedRoteiro);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoteiro(@PathVariable Long id){
		Roteiro roteiro = roteiroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Roteiro não existe com id :" + id));
	
	roteiroRepository.delete(roteiro);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
			
	}
	
	
}
