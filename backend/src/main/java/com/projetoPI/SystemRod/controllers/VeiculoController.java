package com.projetoPI.SystemRod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.VeiculoDTO;
import com.projetoPI.SystemRod.service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<VeiculoDTO> list = veiculoService.findAll();
		return ResponseEntity.ok(list);
	}

}
