package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoPI.SystemRod.dto.CidadeDTO;
import com.projetoPI.SystemRod.entities.Cidade;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<CidadeDTO> findAll(){
		List<Cidade> result = cidadeRepository.findAll();
		return result.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
	}
	

	
	@Transactional
	public Cidade salvarCidade(Cidade cidade) {
		validar(cidade);
		return cidadeRepository.save(cidade);
	}
	
	
	public void validar(Cidade cidade) {
		if(cidade.getCidade() == null || cidade.getCidade().trim().equals("")) {
			throw new ResourceNotFoundException("Informe uma CIDADE válida.");
		}
		
		if(cidade.getUf() == null || cidade.getUf().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um UF válido.");
		}
		
	}
	


}
