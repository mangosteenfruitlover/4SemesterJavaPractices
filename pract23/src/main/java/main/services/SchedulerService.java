package main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@ManagedResource
@Service
public class SchedulerService {
    private static String directoryPath = "entities";
    private static String studentFilePath = directoryPath + "\\student.txt";
    private static String universityFilePath = directoryPath + "\\university.txt";

    @Autowired
    private StudentService studentService;
    @Autowired
    private UniversityService universityService;

    @Scheduled(cron = "0 */30 * * * *")
    @ManagedOperation
    public void updateEntitiesInFiles() {
        try {
            clearDirectoryEntities();

            File studentFile = new File(studentFilePath);
            File universityFile = new File(universityFilePath);

            studentFile.createNewFile();
            universityFile.createNewFile();

            FileWriter fileWriterStudents = new FileWriter(studentFile);
            FileWriter fileWriterUniversities = new FileWriter(universityFile);

            fileWriterStudents.write(studentService.getAll().toString());
            fileWriterUniversities.write(universityService.getAll().toString());

            fileWriterStudents.flush();
            fileWriterUniversities.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearDirectoryEntities() {
        File entitiesDirectory = new File("entities");
        if(!entitiesDirectory.exists()) {
            entitiesDirectory.mkdir();
        }

        for (File myFile : new File("entities").listFiles()) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }
    }
}
