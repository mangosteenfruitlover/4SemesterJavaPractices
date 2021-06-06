package main.services;

import main.model.Student;
import main.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getById(Long id) {
        return repository.findById(id).get();
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public List<Student> getAllSortedBy(String field) {
        return repository.findAll(Sort.by(field));
    }

    public void save(Student value) {
        repository.save(value);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Student> findAllByFirstName(String name) {
        return repository.findAllByFirstName(name);
    }

    public List<Student> findAllByMiddleName(String name) {
        return repository.findAllByMiddleName(name);
    }

    public List<Student> findAllByLastName(String name) {
        return repository.findAllByLastName(name);
    }
}
