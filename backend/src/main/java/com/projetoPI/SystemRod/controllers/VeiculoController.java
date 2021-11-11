package com.projetoPI.SystemRod.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.VeiculoDTO;
import com.projetoPI.SystemRod.entities.Veiculo;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.VeiculoRepository;
import com.projetoPI.SystemRod.service.VeiculoService;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<VeiculoDTO> list = veiculoService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity createVeiculo(@RequestBody Veiculo veiculo) {
		try {

			Veiculo veiculoSalvo = veiculoService.salvarVeiculo(veiculo);
			return new ResponseEntity(veiculoSalvo, HttpStatus.CREATED);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Long id) {
		
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo não existe com id :" + id));
		return ResponseEntity.ok(veiculo) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoDetails){
		
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo não existe com id :" + id));
		
		veiculo.setPlaca(veiculoDetails.getPlaca());
		veiculo.setModelo(veiculoDetails.getModelo());
		veiculo.setDataCompra(veiculoDetails.getDataCompra());
		veiculo.setMotorista(veiculoDetails.getMotorista());
		veiculo.setPoltrona(veiculoDetails.getPoltrona());
		
		Veiculo veiculoSalvo = veiculoService.salvarVeiculo(veiculo);
		Veiculo updatedVeiculo = veiculoRepository.save(veiculo);
		return ResponseEntity.ok(updatedVeiculo);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVeiculo(@PathVariable Long id){
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo não existe com id :" + id));
	
	veiculoRepository.delete(veiculo);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
			
	}

}
