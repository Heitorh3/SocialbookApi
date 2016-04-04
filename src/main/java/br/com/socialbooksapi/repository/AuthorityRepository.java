package br.com.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.socialbooksapi.domain.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
