package br.com.socialbooksapi.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

<<<<<<< HEAD
import org.apache.log4j.Logger;
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> 12d98422aebc8a09124f269e96c8c5673ff8b364
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.socialbooksapi.domain.Authority;
import br.com.socialbooksapi.domain.User;
import br.com.socialbooksapi.repository.AuthorityRepository;
import br.com.socialbooksapi.repository.UserRepository;
import br.com.socialbooksapi.util.RandomUtil;
import br.com.socialbooksapi.util.SecurityUtils;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

<<<<<<< HEAD
	private final Logger LOGGER = Logger.getLogger(this.getClass());
	 
=======
    private final Logger log = LoggerFactory.getLogger(UserService.class);

>>>>>>> 12d98422aebc8a09124f269e96c8c5673ff8b364
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public Optional<User> activateRegistration(String key) {
    	this.LOGGER.debug(String.format("Activating user for activation key [%s]!", key));
        userRepository.findOneByActivationKey(key)
            .map(user -> {
                // activate given user for the registration key.
                user.setActivated(true);
                userRepository.save(user);
                this.LOGGER.debug(String.format("Ativando usuário: []!", user));        
                return user;
            });
        return Optional.empty();
    }

    public Optional<User> completePasswordReset(String newPassword, String key) {
       this.LOGGER.debug(String.format("Resetando a senha do usuário para: [%s]!", key));

       return userRepository.findOneByResetKey(key)
           .map(user -> {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return user;
           });
    }

    public Optional<User> requestPasswordReset(String mail) {
        return userRepository.findOneByEmail(mail)
            .filter(User::getActivated)
            .map(user -> {
                userRepository.save(user);
                return user;
            });
    }

    public User createUserInformation(String login, String password, String firstName, String lastName, String email,
        String langKey) {

        User newUser = new User();
        Authority authority = authorityRepository.findOne("ROLE_USER");
        Set<Authority> authorities = new HashSet<>();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(login);
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setEmail(email);
        // new user is not active
        newUser.setActivated(false);
        // new user gets registration key
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        authorities.add(authority);
        newUser.setAuthorities(authorities);
        userRepository.save(newUser);
        this.LOGGER.debug(String.format("Criando informacao do usuário [%s]!", newUser));
        return newUser;
    }

    public User createUser(User managedUserDTO) {
        User user = new User();
        Set<Authority> authorities = new HashSet<>();

        authorities.add(authorityRepository.findOne("ROLE_USER"));
        
        user.setAuthorities(authorities);
        
        String encryptedPassword = passwordEncoder.encode(managedUserDTO.getPassword());
	        user.setPassword(encryptedPassword);
	        user.setResetKey(RandomUtil.generateResetKey());
	        user.setNome(managedUserDTO.getNome());
	        user.setLogin(managedUserDTO.getLogin());
	        user.setEmail(managedUserDTO.getEmail());
	        user.setActivated(managedUserDTO.getActivated());
	        user.setActivationKey(RandomUtil.generateActivationKey());
	        
	        if(managedUserDTO.getId() != null){
	        	user.setId(managedUserDTO.getId());
	        }
	        
        userRepository.saveAndFlush(user);
        this.LOGGER.debug(String.format("Salvando informacoes do usuario: {}!", user));
        return user;
    }

    public void updateUserInformation(String firstName, String lastName, String email) {
        userRepository.findOneByLogin(SecurityUtils.getCurrentUser().getUsername()).ifPresent(u -> {
            u.setNome(firstName);
            u.setEmail(email);
            userRepository.save(u);
            this.LOGGER.debug(String.format("Atualizando informacoes do usuario: {}!", u));
        });
    }

    public void deleteUserInformation(String login) {
        userRepository.findOneByLogin(login).ifPresent(u -> {
            userRepository.delete(u);
            this.LOGGER.debug(String.format("Deletando um usuario: {}!", u));
        });
    }

    public void changePassword(String password) {
        userRepository.findOneByLogin(SecurityUtils.getCurrentUser().getUsername()).ifPresent(u -> {
            String encryptedPassword = passwordEncoder.encode(password);
            u.setPassword(encryptedPassword);
            userRepository.save(u);
            this.LOGGER.debug(String.format("Carregando a senha do usuario: {}!", u));
        });
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
        return userRepository.findOneByLogin(login).map(u -> {
            u.getAuthorities().size();
            return u;
        });
    }

    @Transactional(readOnly = true)
    public User getUserWithAuthorities(Long id) {
        User user = userRepository.findOne(id);
        user.getAuthorities().size(); // eagerly load the association
        return user;
    }

    @Transactional(readOnly = true)
    public User getUserWithAuthorities() {
        User user = userRepository.findOneByLogin(SecurityUtils.getCurrentUser().getUsername()).get();
        user.getAuthorities().size(); // eagerly load the association
        return user;
    }

    /**
     * Persistent Token are used for providing automatic authentication, they should be automatically deleted after
     * 30 days.
     * <p/>
     * <p>
     * This is scheduled to get fired everyday, at midnight.
     * </p>
     */
   /* @Scheduled(cron = "0 0 0 * * ?")
    public void removeOldPersistentTokens() {
        LocalDate now = LocalDate.now();
        persistentTokenRepository.findByTokenDateBefore(now.minusMonths(1)).stream().forEach(token -> {
            log.debug("Deleting token {}", token.getSeries());
            User user = token.getUser();
            user.getPersistentTokens().remove(token);
            persistentTokenRepository.delete(token);
        });
    }

	public List<User> filtrarUsuer(UsuarioFilter filtro) {
		String nome = filtro.getNome() == null ? "%" : filtro.getNome();
		return userRepository.findByNomeContaining(nome);
	}
*/
	public void desativarUser(long id) {
		userRepository.findOneById(id).ifPresent(u -> {
			u.setActivated(false);
            userRepository.save(u);
            this.LOGGER.debug(String.format("Desativando o usuario: {}!", u));
        });
	}

	public void ativarUser(long id) {
		userRepository.findOneById(id).ifPresent(u -> {
			u.setActivated(true);
            userRepository.save(u);
            this.LOGGER.debug(String.format("Deletando o usuario: {}!", u));
        });
	}

    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p/>
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     * </p>
     */
   /* @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        ZonedDateTime now = ZonedDateTime.now();
        List<User> users = userRepository.findAllByActivatedIsFalseAndCreatedDateBefore(now.minusDays(3));
        for (User user : users) {
            log.debug("Deleting not activated user {}", user.getLogin());
            userRepository.delete(user);
        }
    }*/
}
