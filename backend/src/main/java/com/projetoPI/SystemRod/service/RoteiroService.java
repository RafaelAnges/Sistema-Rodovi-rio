package com.projetoPI.SystemRod.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoPI.SystemRod.dto.RoteiroDTO;
import com.projetoPI.SystemRod.entities.Roteiro;
import com.projetoPI.SystemRod.repositories.CidadeRepository;
import com.projetoPI.SystemRod.repositories.RoteiroRepository;
import com.projetoPI.SystemRod.repositories.VeiculoRepository;

@Service
public class RoteiroService {
	
	@Autowired
	private RoteiroRepository roteiroRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Transactional(readOnly = true)
	public Page<RoteiroDTO> findAll(Pageable pageable){
		cidadeRepository.findAll();
		veiculoRepository.findAll();
		Page<Roteiro> result = roteiroRepository.findAll(pageable);
		return result.map(x -> new RoteiroDTO(x));
	}

}
