package com.projetoPI.SystemRod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.CidadeDTO;
import com.projetoPI.SystemRod.entities.Cidade;
import com.projetoPI.SystemRod.repositories.CidadeRepository;
import com.projetoPI.SystemRod.service.CidadeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/cidades")
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<CidadeDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/add-cidade")
	public Cidade createCidade(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

}
