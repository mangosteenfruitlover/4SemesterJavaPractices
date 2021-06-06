package main.services;

import main.model.Student;
import main.model.University;
import main.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository repository;

    public UniversityService(UniversityRepository repository) {
        this.repository = repository;
    }

    public University getById(Long id) {
        return repository.findById(id).get();
    }

    public List<University> getAll() {
        return repository.findAll();
    }

    public List<University> getAllSortedBy(String field) {
        return repository.findAll(Sort.by(field));
    }

    public void save(University value) {
        repository.save(value);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Student> getStudentsByUniversity(Long id) {
        return repository.findById(id)
                .orElseThrow(NoResultException::new)
                .getStudents();
    }

    public List<University> findAllByCreationDate(String creationDate) {
        return repository.findAllByCreationDate(creationDate);
    }

    public List<University> findAllByName(String name) {
        return repository.findAllByName(name);
    }

}
