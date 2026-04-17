package pe.edu.upeu.university_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.university_crud.entity.Career;


public interface CareerRepository extends JpaRepository<Career,Long> {

}
