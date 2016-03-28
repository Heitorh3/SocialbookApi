package br.com.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.socialbooksapi.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
