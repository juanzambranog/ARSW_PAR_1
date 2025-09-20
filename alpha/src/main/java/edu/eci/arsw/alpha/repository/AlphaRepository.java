package edu.eci.arsw.alpha.repository;

import edu.eci.arsw.alpha.models.Alpha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaRepository extends JpaRepository<Alpha, Long> {
}