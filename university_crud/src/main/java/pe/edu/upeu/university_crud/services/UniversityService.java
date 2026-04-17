package pe.edu.upeu.university_crud.services;

import pe.edu.upeu.university_crud.entity.University;

public interface UniversityService {
    University create (University university);
    University readByName(String name);
    University update (University university, String name);
    void delete (String name);

}
