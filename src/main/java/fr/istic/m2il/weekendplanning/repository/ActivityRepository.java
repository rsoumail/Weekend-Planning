package fr.istic.m2il.weekendplanning.repository;

import fr.istic.m2il.weekendplanning.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the Activity entity.
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findOne(Activity activity);
}
