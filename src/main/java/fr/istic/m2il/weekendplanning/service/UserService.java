package fr.istic.m2il.weekendplanning.service;

import fr.istic.m2il.weekendplanning.config.Constants;
import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.User;

import fr.istic.m2il.weekendplanning.repository.ActivityRepository;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
//import fr.istic.m2il.weekendplanning.security.SecurityUtils;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;
import fr.istic.m2il.weekendplanning.service.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);


    private final UserRepository userRepository;



    //private final PasswordEncoder passwordEncoder ;

    private final ActivityRepository activityRepository;


   // private final CacheManager cacheManager;

    public UserService(UserRepository userRepository, ActivityRepository activityRepository) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
        this.activityRepository = activityRepository;
       // this.cacheManager = cacheManager;
    }

    public User createUser(String login, String email,  String password, String firstName, String lastName) {

        User newUser = new User();
        //String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(login);
        // new user gets initially a generated password
        //newUser.setPassword(encryptedPassword);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
 

        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        /*if (userDTO.getActivities() != null) {
            List<Activity> activities = new ArrayList<>();
            userDTO.getActivities().forEach(
                    activity -> activities.add(activityRepository.findOne(activity))
            );
            user.setActivities(activities);
        }*/
        //String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        //user.setPassword(encryptedPassword);
        userRepository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }



    /**
     * Update basic information (first name, last name, email, language) for the current user.
     *
     * @param firstName first name of user
     * @param lastName last name of user
     * @param email email id of user
     */
    public void updateUser(String firstName, String lastName, String email) {
        /*userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin()).ifPresent(user -> {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            cacheManager.getCache("users").evict(user.getLogin());
            log.debug("Changed Information for User: {}", user);
        });*/
    }

    /**
     * Update all information for a specific user, and return the modified user.
     *
     * @param userDTO user to update
     * @return updated user
     */
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        return Optional.of(userRepository
                .findOne(userDTO.getId()))
                .map(user -> {
                    user.setLogin(userDTO.getLogin());
                    user.setFirstName(userDTO.getFirstName());
                    user.setLastName(userDTO.getLastName());
                    user.setEmail(userDTO.getEmail());

                    List<Activity> activities = user.getActivities();
                    activities.clear();
                   /* userDTO.getActivities().stream()
                            .map(activityRepository::findOne)
                            .forEach(activities::add);*/
                    //cacheManager.getCache("users").evict(user.getLogin());
                    log.debug("Changed Information for User: {}", user);
                    return user;
                })
                .map(UserDTO::new);
    }

    public void deleteUser(String login) {
        userRepository.findOneByLogin(login).ifPresent(user -> {
            userRepository.delete(user);
         //   cacheManager.getCache("users").evict(login);
            log.debug("Deleted User: {}", user);
        });
    }

    public void changePassword(String password) {
        /*userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin()).ifPresent(user -> {
            String encryptedPassword = passwordEncoder.encode(password);
            user.setPassword(encryptedPassword);
            cacheManager.getCache("users").evict(user.getLogin());
            log.debug("Changed password for User: {}", user);
        });*/
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllManagedUsers(Pageable pageable) {
        return userRepository.findAllByLoginNot(pageable, Constants.ANONYMOUS_USER).map(UserDTO::new);
    }

}
