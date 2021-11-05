package com.projetoPI.SystemRod.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.RoteiroDTO;
import com.projetoPI.SystemRod.service.RoteiroService;

@RestController
@RequestMapping(value = "/roteiros")
public class RoteiroController {
	
	@Autowired
	private RoteiroService roteiroService;
	
	@GetMapping
	public ResponseEntity<Page<RoteiroDTO>> findAll(Pageable pageable){
		Page<RoteiroDTO> list = roteiroService.findAll(pageable);
		return ResponseEntity.ok(list);
	}

}
