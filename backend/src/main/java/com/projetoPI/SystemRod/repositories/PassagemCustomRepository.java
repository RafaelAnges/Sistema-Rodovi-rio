package com.projetoPI.SystemRod.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import com.projetoPI.SystemRod.entities.Passagem;

@Repository
public class PassagemCustomRepository {
	
	private final EntityManager em;
	
	public PassagemCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Passagem> find(String name, String email){
		
		String query = "select P from Passagem as P ";
		String condicao = "where";
		
		if(name != null) {
			query += condicao + " P.name = :name";
			condicao = " and";
		}
		
		if(email != null) {
			query += condicao + " P.email = :email";
			condicao = " and";
		}
		
		var q = em.createQuery(query, Passagem.class);
		
		if(name != null) {
			q.setParameter( "name", name);
		}
		
		if(email != null) {
			q.setParameter( "email", email);
		}
		
		return q.getResultList();
		
	}

}
