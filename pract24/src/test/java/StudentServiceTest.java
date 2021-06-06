import main.model.Student;
import main.repository.StudentRepository;
import main.services.EmailService;
import main.services.StudentService;
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
public class StudentServiceTest {

    @Mock
    private StudentRepository studentService;

    @Captor
    ArgumentCaptor<Student> studentArgumentCaptor;

    @Test
    void saveStudent() {
        Student student = new Student();
        student.setFirstName("Lesha");
        student.setMiddleName("Leshovich");
        student.setLastName("Leshov");

        StudentService studentService = new StudentService(this.studentService, new EmailService());

        studentService.save(student);
        Mockito.verify(this.studentService).save(studentArgumentCaptor.capture());
        Student captured = studentArgumentCaptor.getValue();

        Assertions.assertEquals("Lesha", captured.getFirstName());
        Assertions.assertEquals("Leshovich", captured.getMiddleName());
        Assertions.assertEquals("Leshov", captured.getLastName());
    }

    @Test
    void getUniversitiesSize(){
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        student1.setFirstName("Lesha");
        student1.setFirstName("Masha");
        student1.setFirstName("Andrey");

        Mockito.when(
                studentService.findAll())
                .thenReturn(List.of(student1, student2, student3));

        Assertions.assertEquals(3,
                new StudentService(studentService, new EmailService())
                        .getAll()
                        .size());
    }

    @Test
    void deleteStudent() {
        Student student = new Student();
        student.setFirstName("Yaroslav");
        student.setLastName("Bobikov");

        StudentService studentService = new StudentService(this.studentService, new EmailService());

        studentService.save(student);
        Mockito.verify(this.studentService).save(studentArgumentCaptor.capture());

        studentService.delete(1);

        Assertions.assertEquals(0,
                new StudentService(this.studentService, new EmailService())
                        .getAll()
                        .size());
    }
}
