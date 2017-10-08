package fr.istic.m2il.weekendplanning.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Une Activité () .
 */

@Entity
@Table(name = "activity")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Activity implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 0, max = 50)
    @Id
    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "activities")
    private List<User> users = new ArrayList<User>();
   // private List<Place> place = new ArrayList<Place>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

   /* @JsonIgnore
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "activity_place",
            joinColumns = {@JoinColumn(name = "activity_id", referencedColumnName = "id")}

    )
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }
*/
    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                "}";
    }
>>>>>>> Modification pour amélioration de l'API
}
