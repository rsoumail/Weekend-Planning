package fr.istic.m2il.weekendplanning.web.rest;

import fr.istic.m2il.weekendplanning.domain.Authority;
import fr.istic.m2il.weekendplanning.repository.AuthorityRepository;
import fr.istic.m2il.weekendplanning.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorityResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private static final String ENTITY_NAME = "authorityManagement";

    @Autowired
    private final AuthorityRepository authorityRepository;

    public AuthorityResource(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @PostMapping(path = "/authorities",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity createAuthority(@Valid @RequestBody Authority authority) throws URISyntaxException{
        log.debug("REST request to save Authority : {}", authority);
        if(authority.getId() != null){
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new authority cannot already have an ID"))
                    .body(null);
        }else if (authorityRepository.findOneAuthoritieByName(authority.getName().toLowerCase()).isPresent()) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "authorityexists", "Authority name already in use"))
                    .body(null);
        }else {

            authorityRepository.save(authority);
            return ResponseEntity.created(new URI("/api/autorities/" + authority.getName()))
                    .headers(HeaderUtil.createAlert( "A authority is created with identifier " + authority.getName(), authority.getName()))
                    .body(authority);
        }


    }

    @GetMapping("/authorities")
    public Optional<Authority> getAuthority(@PathVariable String name){

        return authorityRepository.findOneAuthoritieByName(name);
    }
}
