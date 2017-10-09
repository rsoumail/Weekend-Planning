package fr.istic.m2il.weekendplanning.web.rest;

import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import fr.istic.m2il.weekendplanning.service.UserService;
import fr.istic.m2il.weekendplanning.web.rest.util.HeaderUtil;
import fr.istic.m2il.weekendplanning.web.rest.vm.ManagedUserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private static final String ENTITY_NAME = "userManagement";

    @Autowired
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;

    public UserResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    /**
     * POST  /users  : Crée un nouvel utilsateur.
     * <p>
     * Crée un nouvel utilsateur si le login et l'adresse email ne sont pas encore utilisés.
     *
     * @param managedUserVM the user to create
     * @return la ResponseEntity avec le status 201 (Créée) avec le contenu du nouvel utilisateur, ou avec le status 400 (Bad Request) si le login et l'adresse email sont déjà utilisés
     * @throws URISyntaxException si la synthaxe de l'URI est incorrecte
     */
    public ResponseEntity createUser (@Valid @RequestBody ManagedUserVM managedUserVM) throws URISyntaxException{
        log.debug("REST request to save User : {}", managedUserVM);

        if (managedUserVM.getId() != null) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new user cannot already have an ID"))
                    .body(null);
            // Lowercase the user login before comparing with database
        } else if (userRepository.findOneByLogin(managedUserVM.getLogin().toLowerCase()).isPresent()) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "userexists", "Login already in use"))
                    .body(null);
        } else if (userRepository.findOneByEmailIgnoreCase(managedUserVM.getEmail()).isPresent()) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "emailexists", "Email already in use"))
                    .body(null);
        } else {
            User newUser = userService.createUser(managedUserVM);
           // mailService.sendCreationEmail(newUser);
            return ResponseEntity.created(new URI("/api/users/" + newUser.getLogin()))
                    .headers(HeaderUtil.createAlert( "A user is created with identifier " + newUser.getLogin(), newUser.getLogin()))
                    .body(newUser);
        }
    }

    @GetMapping("/all")
    public Optional<User> get (){
        return userRepository.findOneByLogin("");
    }
}
