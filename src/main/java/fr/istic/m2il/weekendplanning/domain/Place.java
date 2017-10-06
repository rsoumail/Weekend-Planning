package fr.istic.m2il.weekendplanning.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Place implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToMany(mappedBy="places")
   // private List<User> users = new ArrayList<User>();

   // @ManyToMany(mappedBy="places")
   // private List<Activity> activities = new ArrayList<Activity>();
}
