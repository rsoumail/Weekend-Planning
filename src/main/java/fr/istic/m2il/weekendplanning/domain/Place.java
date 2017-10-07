package fr.istic.m2il.weekendplanning.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;

    
    private long id;
    
    private List<Person> persons = new ArrayList<Person>();
    private List<Activity> activity = new ArrayList<Activity>();
    
    
    @Id
    @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToMany(mappedBy="places")
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	@ManyToMany(mappedBy="palces")
	public List<Activity> getActivity() {
		return activity;
	}
	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	} 

   // @ManyToMany(mappedBy="places")
   // private List<User> users = new ArrayList<User>();

   // @ManyToMany(mappedBy="places")
   // private List<Activity> activities = new ArrayList<Activity>();
}
