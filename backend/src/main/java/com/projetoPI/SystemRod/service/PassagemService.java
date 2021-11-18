package com.projetoPI.SystemRod.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoPI.SystemRod.dto.PassagemDTO;
import com.projetoPI.SystemRod.entities.Passagem;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.PassagemRepository;


@Service
public class PassagemService {

	@Autowired
	private PassagemRepository passagemRepository;
	
	public List<PassagemDTO> findAll(){
		List<Passagem> result = passagemRepository.findAll();
		return result.stream().map(x -> new PassagemDTO(x)).collect(Collectors.toList());
	}
	

	
	@Transactional
	public Passagem salvarPassagem(Passagem passagem) {
		validar(passagem);
		return passagemRepository.save(passagem);
	}
	
	public void validar(Passagem passagem) {
		if(passagem.getCidadeOrigem() == null || passagem.getCidadeOrigem().trim().equals("")) {
			throw new ResourceNotFoundException("Informe uma ORIGEM válida.");
		}
		
		if(passagem.getCidadeDestino() == null || passagem.getCidadeDestino().trim().equals("")) {
			throw new ResourceNotFoundException("Informe um DESTINO válido.");
		}
		
		if(passagem.getDataSaida() == null || passagem.getDataSaida().toString().equals("")) {
			throw new ResourceNotFoundException("Informe uma DATA válida.");
		}
		
		if(passagem.getHoraSaida() == null || passagem.getHoraSaida().toString().equals("")) {
			throw new ResourceNotFoundException("Informe um HORA válido.");
		}
		
		if(passagem.getVeiculo() == null || passagem.getVeiculo().trim().equals("")) {
			throw new ResourceNotFoundException("Informe uma VEICULO válida.");
		}
		
	
		
		if(passagem.getPoltrona() == null || passagem.getPoltrona().toString().equals("")) {
			throw new ResourceNotFoundException("Informe um POLTRONA válido.");
		}
		
		if(passagem.getValor() == null || passagem.getValor().toString().equals("")) {
			throw new ResourceNotFoundException("Informe uma VALOR válida.");
		}
		
		
	}
	
}
