package fr.istic.m2il.weekendplanning.web.rest;


import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.repository.ActivityRepository;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActivityResource {

    private final ActivityRepository activityRepository;

    public ActivityResource(ActivityRepository activityRepository) {

        this.activityRepository = activityRepository;
    }

   /* @GetMapping(path = "/activities")
    @ResponseBody
    public ResponseEntity get (@Valid @RequestBody Activity activity){
        return new ResponseEntity<>(activityRepository.findOne(activity.getName()), HttpStatus.OK);
    }*/

    @PostMapping(path = "/activities")
    public ResponseEntity addActivity(@Valid @RequestBody Activity activity){
        Activity newActivity = new Activity();
        newActivity.setName(activity.getName());
        newActivity.setTemperatureMin(activity.getTemperatureMin());
        newActivity.setTemperatureMax(activity.getTemperatureMax());
        newActivity.setWindMin(activity.getWindMin());
        newActivity.setWindMax(activity.getWindMax());
        newActivity.setConditions(activity.getConditions());
        for(String string: activity.getConditions()){
            System.out.println("Condition: " + string);
        }
        activityRepository.save(newActivity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * GET  /activities : get all activities.
     *
     * @return the ResponseEntity with status 200 (OK) and with body all activities
     */
    @GetMapping("/activities")
    //@Timed
    public ResponseEntity getActivities() {
        /*final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);*/
        /*return activityRepository.findAll().stream().map(activity -> {
            return new ResponseEntity<>(HttpStatus.OK);
        }).orElseGet(() -> {
            *//*log.info("Login: " + managedUserVM.getLogin());
            log.info("Password: " + managedUserVM.getPassword());
            User user = userService
                    .createUser(managedUserVM.getLogin(), managedUserVM.getEmail().toLowerCase(),
                            managedUserVM.getPassword()*//**//*, managedUserVM.getFirstName(), managedUserVM.getLastName()*//**//*
                    );*//*
            return new ResponseEntity<>(HttpStatus.CREATED);
        })*/
        if(activityRepository.findAll().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(activityRepository.findAll(), HttpStatus.OK);
        }
    }
}
