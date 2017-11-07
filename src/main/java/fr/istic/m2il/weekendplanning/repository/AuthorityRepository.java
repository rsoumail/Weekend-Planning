package fr.istic.m2il.weekendplanning.repository;

import fr.istic.m2il.weekendplanning.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findOneAuthoritieByName(String name);
}
