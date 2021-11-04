package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoPI.SystemRod.dto.VeiculoDTO;
import com.projetoPI.SystemRod.entities.Veiculo;
import com.projetoPI.SystemRod.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<VeiculoDTO> findAll(){
		List<Veiculo> result = veiculoRepository.findAll();
		return result.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
	}

}
