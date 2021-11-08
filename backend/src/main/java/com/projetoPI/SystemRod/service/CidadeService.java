package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.SystemRod.dto.CidadeDTO;
import com.projetoPI.SystemRod.entities.Cidade;
import com.projetoPI.SystemRod.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<CidadeDTO> findAll(){
		List<Cidade> result = cidadeRepository.findAll();
		return result.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
	}
	


}
