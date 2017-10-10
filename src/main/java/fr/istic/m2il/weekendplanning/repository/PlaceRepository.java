package fr.istic.m2il.weekendplanning.repository;

import fr.istic.m2il.weekendplanning.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the Place entity.
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findOne(Long id);


}
