package main.services;

import lombok.extern.slf4j.Slf4j;
import main.model.Student;
import main.model.University;
import main.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository repository;
    private final EmailService emailService;

    public UniversityService(UniversityRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Transactional(readOnly = true)
    public University getById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<University> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<University> getAllSortedBy(String field) {
        return repository.findAll(Sort.by(field));
    }

    @Transactional
    @Async
    public void save(University value) {
        repository.save(value);
        emailService.send(value);
    }

    @Transactional
    @Async
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> getStudentsByUniversity(Long id) {
        return repository.findById(id)
                .orElseThrow(NoResultException::new)
                .getStudents();
    }

    @Transactional(readOnly = true)
    public List<University> findAllByCreationDate(String creationDate) {
        return repository.findAllByCreationDate(creationDate);
    }

    @Transactional(readOnly = true)
    public List<University> findAllByName(String name) {
        return repository.findAllByName(name);
    }
}
