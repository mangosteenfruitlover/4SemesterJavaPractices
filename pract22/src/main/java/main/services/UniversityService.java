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
@Slf4j
public class UniversityService {
    private final UniversityRepository repository;
    private final EmailService emailService;

    public UniversityService(UniversityRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Transactional(readOnly = true)
    public University getById(Long id) {
        log.info("Get university with id {}", id);
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<University> getAll() {
        log.info("Get all universities");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<University> getAllSortedBy(String field) {
        log.info("Get all universities sorted by field {}", field);
        return repository.findAll(Sort.by(field));
    }

    @Transactional
    @Async
    public void save(University value) {
        log.info("Save university with value {}", value);
        repository.save(value);
        emailService.send(value);
    }

    @Transactional
    @Async
    public void delete(long id) {
        log.info("Delete university with id {}", id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> getStudentsByUniversity(Long id) {
        log.info("Get students by university id {}", id);
        return repository.findById(id)
                .orElseThrow(NoResultException::new)
                .getStudents();
    }

    @Transactional(readOnly = true)
    public List<University> findAllByCreationDate(String creationDate) {
        log.info("Find all universities by creationDate with value {}", creationDate);
        return repository.findAllByCreationDate(creationDate);
    }

    @Transactional(readOnly = true)
    public List<University> findAllByName(String name) {
        log.info("Find all universities by name with value {}", name);
        return repository.findAllByName(name);
    }
}
