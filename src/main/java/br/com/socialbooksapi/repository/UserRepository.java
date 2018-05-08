package br.com.socialbooksapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.socialbooksapi.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

Optional<User> findByLogin(String login);
	
Optional<User> findOneByActivationKey(String activationKey);
	
Optional<User> findOneByResetKey(String resetKey);
	
Optional<User> findOneByEmail(String email); 
    
Optional<User> findOneByLogin(String login);
   
Optional<User> findOneById(Long userId);
       
List<User>findByNomeContaining(String nome);

    @Override
    void delete(User t);
}
