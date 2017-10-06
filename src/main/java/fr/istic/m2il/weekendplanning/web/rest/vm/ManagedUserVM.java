package fr.istic.m2il.weekendplanning.web.rest.vm;

import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;
import javax.validation.constraints.Size;

import java.time.Instant;
import java.util.List;
import java.util.Set;

/**
 * View Model extending the UserDTO, which is meant to be used in the user management UI.
 */
public class ManagedUserVM extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUserVM() {
        // Empty constructor needed for Jackson.
    }

    public ManagedUserVM(Long id, String email,  String login, String password, String firstName, String lastName,
                        List<Activity> activities) {

        super(id, email, login, firstName, lastName, activities);

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
            "} " + super.toString();
    }
}
