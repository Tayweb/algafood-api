package com.algaworks.algafood.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	Page<Cozinha> findByNomeContaining(String nome, Pageable pageable);

	// List<Cozinha> nome(String nome);

}
