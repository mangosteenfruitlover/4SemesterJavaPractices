package main.services;

import main.model.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class UniversityService extends DBService<University> {
    public UniversityService(SessionFactory sessionFactory) {
        super(sessionFactory, University.class);
    }
}
