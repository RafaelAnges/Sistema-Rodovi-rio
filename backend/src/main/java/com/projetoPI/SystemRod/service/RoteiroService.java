package com.projetoPI.SystemRod.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoPI.SystemRod.dto.RoteiroDTO;
import com.projetoPI.SystemRod.entities.Roteiro;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.RoteiroRepository;

@Service
public class RoteiroService {
	
	@Autowired
	private RoteiroRepository roteiroRepository;
	
	
	

	public List<RoteiroDTO> findAll(){
		List<Roteiro> result = roteiroRepository.findAll();
		return result.stream().map(x -> new RoteiroDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public Roteiro salvarRoteiro(Roteiro roteiro) {
		validar(roteiro);
		return roteiroRepository.save(roteiro);
	}
	
	
	public void validar(Roteiro roteiro) {
		if(roteiro.getCidade() == null || roteiro.getCidade().toString().equals("")) {
			throw new ResourceNotFoundException("Informe uma CIDADE válida.");
		}
		
		if(roteiro.getModelo() == null || roteiro.getModelo().toString().equals("")) {
			throw new ResourceNotFoundException("Informe um UF válido.");
		}
		
		if(roteiro.getPoltrona() == null || roteiro.getPoltrona().toString().equals("")) {
			throw new ResourceNotFoundException("Informe um UF válido.");
		}
		
		
	}

}
