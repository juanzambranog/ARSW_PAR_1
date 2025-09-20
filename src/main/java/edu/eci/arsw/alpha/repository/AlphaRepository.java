package edu.eci.arsw.alpha.repository;

import edu.eci.arsw.alpha.models.Alpha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaRepository extends JpaRepository<Alpha, Long> {

    // Custom query methods can be added here if needed
    // For example: List<Alpha> findByNameContainingIgnoreCase(String name);
}
