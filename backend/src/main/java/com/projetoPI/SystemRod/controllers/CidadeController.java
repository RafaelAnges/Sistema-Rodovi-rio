package com.projetoPI.SystemRod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.CidadeDTO;
import com.projetoPI.SystemRod.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<CidadeDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

}
