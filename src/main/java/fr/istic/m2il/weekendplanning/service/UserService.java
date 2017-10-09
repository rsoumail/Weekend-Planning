package fr.istic.m2il.weekendplanning.service;

import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.User;

import fr.istic.m2il.weekendplanning.repository.ActivityRepository;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;
import fr.istic.m2il.weekendplanning.service.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private final UserRepository userRepository;

    //private final PasswordEncoder passwordEncoder ;
    @Autowired
    private final ActivityRepository activityRepository;

    //private final CacheManager cacheManager;

    public UserService(UserRepository userRepository, ActivityRepository activityRepository) {
        this.userRepository = userRepository;
       // this.passwordEncoder = passwordEncoder;
        this.activityRepository = activityRepository;
     //   this.cacheManager = cacheManager;
    }

    public User createUser(String login, String email,  String password, String firstName, String lastName) {

        User newUser = new User();
        /*String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(login);
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
 

        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);*/
        return newUser;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        if (userDTO.getActivities() != null) {
            List<Activity> activities = new ArrayList<>();
            /*userDTO.getActivities().forEach(
                    activity -> activities.add(activityRepository.findOne(activity))
            );*/
            user.setActivities(activities);
        }
        //String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        //user.setPassword(encryptedPassword);
        userRepository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

}
