package com.projetoPI.SystemRod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoPI.SystemRod.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
