package fr.istic.m2il.weekendplanning.web.rest;


import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActivityResource {

    private final UserRepository userRepository;

    public ActivityResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/activities")
    @ResponseBody
    public Optional<User> get (){
        return userRepository.findOneByLogin("");
    }
}
