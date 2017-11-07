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


    @Column(name = "wind_min", nullable = false)
    private Integer windMin;
    @Column(name = "wind_max", nullable = false)
    private Integer windMax;
    @Column(name = "temperature_max", nullable = false)
    private Integer temperatureMax;
    @Column(name = "temperature_min", nullable = false)
    private Integer temperatureMin;
    @Column(name = "conditions")
    @ElementCollection
    private List<String> conditions = new ArrayList<>();

    @ManyToMany(mappedBy = "activities")
    private List<User> users = new ArrayList<User>();

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

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                "}";
    }

    public Integer getWindMin() {
        return windMin;
    }

    public void setWindMin(Integer windMin) {
        this.windMin = windMin;
    }

    public Integer getWindMax() {
        return windMax;
    }

    public void setWindMax(Integer windMax) {
        this.windMax = windMax;
    }

    public Integer getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Integer temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Integer getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Integer temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }
}
