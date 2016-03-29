package br.com.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.socialbooksapi.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
	
}
