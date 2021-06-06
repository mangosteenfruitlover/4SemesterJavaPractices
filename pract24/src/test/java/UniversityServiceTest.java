import main.model.University;
import main.repository.UniversityRepository;
import main.services.EmailService;
import main.services.UniversityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UniversityServiceTest {

    @Mock
    private UniversityRepository universityRepository;

    @Captor
    ArgumentCaptor<University> universityArgumentCaptor;

    @Test
    void saveUniversity() {
        University university = new University();
        university.setName("University1");
        university.setCreationDate("01.01.1970");

        UniversityService universityService = new UniversityService(universityRepository, new EmailService());

        universityService.save(university);
        Mockito.verify(universityRepository).save(universityArgumentCaptor.capture());
        University captured = universityArgumentCaptor.getValue();

        Assertions.assertEquals("01.01.1970", captured.getCreationDate());
        Assertions.assertEquals("University1", captured.getName());
    }

    @Test
    void getUniversitiesSize(){
        University university1 = new University();
        University university2 = new University();
        University university3 = new University();

        university1.setName("University1");
        university1.setName("University2");
        university1.setName("University3");

        Mockito.when(
                universityRepository.findAll())
                .thenReturn(List.of(university1, university2, university3));

        Assertions.assertEquals(3,
                new UniversityService(universityRepository, new EmailService())
                        .getAll()
                        .size());
    }

    @Test
    void deleteUniversity() {
        University university = new University();
        university.setName("University1");
        university.setCreationDate("01.01.1970");

        UniversityService universityService = new UniversityService(universityRepository, new EmailService());

        universityService.save(university);
        Mockito.verify(universityRepository).save(universityArgumentCaptor.capture());

        universityService.delete(1);

        Assertions.assertEquals(0,
                new UniversityService(universityRepository, new EmailService())
                        .getAll()
                        .size());
    }
}
