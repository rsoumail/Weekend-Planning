package fr.istic.m2il.weekendplanning.security;

import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * Authenticate a user from the database.
 */
@Service("userDetailsService")
@Transactional
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);


    private final UserRepository userRepository;


    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) {
        log.debug("Authenticating {}", login);
        Optional<User> userFromDatabase = userRepository.findOneWithAuthoritiesByLogin(login);
        if (userFromDatabase == null) {
            throw new UsernameNotFoundException(login);
        }
        return new CustomUserPrincipal(userFromDatabase.get());
    }
}
