package main.controller;

import main.model.Student;
import main.model.University;
import main.services.StudentService;
import main.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UniversityService universityService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "home.html";
    }

    @RequestMapping(value = "/home/create-student", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentService.insert(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/create-university", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<University> createUniversity(@RequestBody University university) {
        universityService.insert(university);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/student/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        studentService.delete(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/university/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<University> deleteUniversity(@PathVariable("id") Long id) {
        University university = universityService.getById(id);
        universityService.delete(university);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/get-students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/get-universities", method = RequestMethod.GET)
    public ResponseEntity<List<University>> getUniversities() {
        return new ResponseEntity<>(universityService.getAll(), HttpStatus.OK);
    }
}