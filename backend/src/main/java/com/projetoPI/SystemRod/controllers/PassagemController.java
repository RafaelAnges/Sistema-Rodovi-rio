package com.projetoPI.SystemRod.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoPI.SystemRod.dto.PassagemDTO;
import com.projetoPI.SystemRod.entities.Passagem;
import com.projetoPI.SystemRod.exception.ResourceNotFoundException;
import com.projetoPI.SystemRod.repositories.PassagemRepository;
import com.projetoPI.SystemRod.repositories.PassagemCustomRepository;
import com.projetoPI.SystemRod.service.PassagemService;


@RestController
@RequestMapping("/api/v1/passagens")
public class PassagemController {

	@Autowired
	private PassagemService passagemService;

	@Autowired
	private PassagemRepository passagemRepository;
	
	@Autowired
	private PassagemCustomRepository passagemCustomRepository;

	 @GetMapping
	 public ResponseEntity<List<PassagemDTO>> findAll() {
	 List<PassagemDTO> list = passagemService.findAll();
	 return ResponseEntity.ok(list);
	}
	 
	// @GetMapping("/filter")
	// public ResponseEntity<List<PassagemDTO>> findByRestamContains() {
	 //List<PassagemDTO> list = passagemService.findAll();
	// return ResponseEntity.ok(list);
//	}
	 
	 @GetMapping("/filter/custom")
	 public List<Passagem> findPersonByCustom(
			 @RequestParam(value = "name", required = false) String name,
			 @RequestParam(value = "email", required = false) String email
			 ){
		 return this.passagemCustomRepository.find(name, email)
				 .stream()
				 .collect(Collectors.toList());
	 

	 }

	@PostMapping
	public ResponseEntity createPassagem(@RequestBody Passagem passagem) {

		try {

			Passagem passagemSalvo = passagemService.salvarPassagem(passagem);
			return new ResponseEntity(passagemSalvo, HttpStatus.CREATED);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}

	}
	


	@GetMapping("/{id}")
    public ResponseEntity<Passagem> getPassagemById(@PathVariable Long id) {

		Passagem passagem = passagemRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Passagem não existe com id :" + id));
		return ResponseEntity.ok(passagem);
}

	/*
	 * @PutMapping("/{id}") public ResponseEntity<Passagem>
	 * updatePassagem(@PathVariable Long id, @RequestBody Passagem passagemDetails){
	 * 
	 * Passagem passagem = passagemRepository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Passagem não existe com id :" + id));
	 * 
	 * passagem.setLogin(passagemDetails.getLogin());
	 * passagem.setNome(passagemDetails.getNome());
	 * passagem.setCargo(passagemDetails.getCargo());
	 * passagem.setEmail(passagemDetails.getEmail());
	 * passagem.setSenha(passagemDetails.getSenha());
	 * 
	 * Passagem updatedPassagem = passagemRepository.save(passagem); return
	 * ResponseEntity.ok(updatedPassagem);
	 * 
	 * }
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePassagem(@PathVariable Long id) {
		Passagem passagem = passagemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passagem não existe com id :" + id));

		passagemRepository.delete(passagem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

}
