package fr.istic.m2il.weekendplanning.service.dto;

//import fr.istic.m2il.weekendplanning.config.Constants;
import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.Authority;
import fr.istic.m2il.weekendplanning.domain.Place;
import fr.istic.m2il.weekendplanning.domain.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his activities.
 */
public class UserDTO {

    private Long id;

    @Email
    @Size(min = 5, max = 100)
    private String email;

    @NotBlank
   // @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    private List<Activity> activities ;

    private Set<String> authorities;

    private List<Place> places;


    public UserDTO() {
        // Empty constructor needed for Jackson.
    }

    public UserDTO(User user){

        this(user.getId(), user.getEmail(), user.getLogin(), user.getFirstName(), user.getLastName(),
            user.getActivities(), user.getPlaces(), user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet())
        );

    }

    public UserDTO(Long id, String email, String login, String firstName, String lastName, List<Activity> activities, List<Place> places, Set<String> authorities) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activities = activities;
        this.places = places;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activities=" + activities +
                ", authorities=" + authorities +
                "}";
    }


}
