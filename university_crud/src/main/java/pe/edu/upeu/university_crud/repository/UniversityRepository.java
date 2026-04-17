package pe.edu.upeu.university_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.university_crud.entity.University;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {
    Optional<University> findByName(String name);
}
