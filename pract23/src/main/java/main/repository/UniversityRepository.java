package main.repository;

import main.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findAllByName(String name);
    List<University> findAllByCreationDate(String date);
}

