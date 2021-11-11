package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoPI.SystemRod.dto.VeiculoDTO;
import com.projetoPI.SystemRod.entities.Veiculo;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<VeiculoDTO> findAll(){
		List<Veiculo> result = veiculoRepository.findAll();
		return result.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public Veiculo salvarVeiculo(Veiculo veiculo) {
		validar(veiculo);
		return veiculoRepository.save(veiculo);
	}
	
	public void validar(Veiculo veiculo) {
		if(veiculo.getDataCompra() == null || veiculo.getDataCompra().toString().equals("")) {
			throw new ResourceNotFoundException("Informe uma DATA válida.");
		}
		
		if(veiculo.getPlaca() == null || veiculo.getPlaca().trim().equals("")) {
			throw new ResourceNotFoundException("Informe uma PLACA válido.");
		}
		
		if(veiculo.getMotorista() == null || veiculo.getMotorista().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um NOME válida.");
		}
		
		if(veiculo.getModelo() == null || veiculo.getModelo().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um MODELO válido.");
		}
		
		if(veiculo.getPoltrona() == null || veiculo.getPoltrona().toString().equals("")) {
			throw new ResourceNotFoundException("Informe uma POLTRONA válida.");
		}
		
	}

}
