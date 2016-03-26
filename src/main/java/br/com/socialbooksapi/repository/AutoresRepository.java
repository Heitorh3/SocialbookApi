package br.com.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.socialbooksapi.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
