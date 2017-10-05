package fr.istic.m2il.weekendplanning.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import fr.istic.m2il.weekendplanning.config.Constants;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.validator.constraints.Email;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A user.
 */
@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Size(min = 5, max = 100)
    @Column(length = 100, unique = true)
    private String email;
    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash",length = 60)
    private String password;

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "user_activity",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
            
    )
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private List<Activity> activities = new ArrayList<Activity>();

}
