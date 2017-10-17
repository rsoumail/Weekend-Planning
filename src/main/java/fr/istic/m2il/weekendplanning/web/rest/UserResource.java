package fr.istic.m2il.weekendplanning.web.rest;

import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import fr.istic.m2il.weekendplanning.service.UserService;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;
import fr.istic.m2il.weekendplanning.web.rest.util.HeaderUtil;
import fr.istic.m2il.weekendplanning.web.rest.util.PaginationUtil;
import fr.istic.m2il.weekendplanning.web.rest.vm.ManagedUserVM;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Produces;

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
    @PostMapping("/users")
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
    @Produces("application/json")
    public Optional<User> get (){
        return userRepository.findOneByLogin("");
    }

    /**
     * GET  /users : get all users.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     */
    @GetMapping("/users")
    //@Timed
    public ResponseEntity<List<UserDTO>> getAllUsers(Pageable pageable) {
        final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
