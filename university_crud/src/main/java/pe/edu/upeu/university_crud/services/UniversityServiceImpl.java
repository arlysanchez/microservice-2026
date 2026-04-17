package pe.edu.upeu.university_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pe.edu.upeu.university_crud.entity.University;
import pe.edu.upeu.university_crud.repository.UniversityRepository;

import java.util.NoSuchElementException;

@Service
@Transactional
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University create(University university) {
        return this.universityRepository.save(university);
    }

    @Override
    public University readByName(String name) {
        return this.universityRepository.findByName(name)
                .orElseThrow(()-> new NoSuchElementException("University not found"));

    }

    @Override
    public University update(University university, String name) {
        var universityToUpdate = this.universityRepository.findByName(name)
                .orElseThrow(()-> new NoSuchElementException("University not found"));
        universityToUpdate.setCountry(university.getCountry());
        universityToUpdate.setFoundationYear(university.getFoundationYear());
        universityToUpdate.setLogo(university.getLogo());
        return this.universityRepository.save(universityToUpdate);
    }

    @Override
    public void delete(String name) {
        var universityToDelete = this.universityRepository.findByName(name)
                .orElseThrow(()-> new NoSuchElementException("University not found"));
        this.universityRepository.delete(universityToDelete);

    }
}
