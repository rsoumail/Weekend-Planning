package fr.istic.m2il.weekendplanning.service.mapper;

import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;

import fr.istic.m2il.weekendplanning.domain.Activity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user);
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        return users.stream()
            .filter(Objects::nonNull)
            .map(this::userToUserDTO)
            .collect(Collectors.toList());
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setLogin(userDTO.getLogin());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            List<String> activitiesNames = new ArrayList<>();
            for(Activity activity:userDTO.getActivities()){
                activitiesNames.add(activity.getName());
            }
            List<Activity> activities = this.activitiesFromStrings(activitiesNames);
            if(activities != null) {
                user.setActivities(activities);
            }
            return user;
        }
    }

    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::userDTOToUser)
            .collect(Collectors.toList());
    }

    public User userFromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

    public List<Activity> activitiesFromStrings(List<String> strings) {
        return strings.stream().map(string -> {
            Activity activity = new Activity();
            activity.setName(string);
            return activity;
        }).collect(Collectors.toList());
    }
}
