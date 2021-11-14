package com.projetoPI.SystemRod.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.CidadeDTO;
import com.projetoPI.SystemRod.entities.Cidade;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.CidadeRepository;
import com.projetoPI.SystemRod.service.CidadeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/cidades")
public class CidadeController {

	@Autowired
	private CidadeService service;

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<CidadeDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	

	@PostMapping
	public ResponseEntity createCidade(@RequestBody Cidade cidade) {
		try {

			Cidade cidadeSalvo = service.salvarCidade(cidade);
			return new ResponseEntity(cidadeSalvo, HttpStatus.CREATED);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> getCidadeById(@PathVariable Long id) {

		Cidade cidade = cidadeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade não existe com id :" + id));
		return ResponseEntity.ok(cidade);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cidade> updateCidade(@PathVariable Long id, @RequestBody Cidade cidadeDetails) {

		Cidade cidade = cidadeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade não existe com id :" + id));

		cidade.setCidade(cidadeDetails.getCidade());
		cidade.setUf(cidadeDetails.getUf());
		
		Cidade cidadeSalvo = service.salvarCidade(cidade);
		Cidade updatedCidade = cidadeRepository.save(cidade);
		return ResponseEntity.ok(updatedCidade);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCidade(@PathVariable Long id) {
		Cidade cidade = cidadeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade não existe com id :" + id));

		cidadeRepository.delete(cidade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

}
