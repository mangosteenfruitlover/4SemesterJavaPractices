package main.controller;

import main.model.Student;
import main.model.University;
import main.services.StudentService;
import main.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UniversityService universityService;


    @GetMapping(value = "/home")
    public String getHomePage() {
        return "home.html";
    }

    @PostMapping(value = "/home/create-student/{university_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student student, @PathVariable("university_id") Long universityId) {
        University university = universityService.getById(universityId);
        student.setUniversity(university);
        studentService.saveOrUpdate(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/create-university", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<University> createUniversity(@RequestBody University university) {
        universityService.saveOrUpdate(university);
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

    @GetMapping(value = "/home/student/{id}/get-university")
    @ResponseBody
    public ResponseEntity<University> getUniversityByStudent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getUniversityByStudent(id), HttpStatus.OK);
    }

    @GetMapping("/home/students/orderBy/{field}")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsOrderedBy(@PathVariable String field) {
        return new ResponseEntity<>(studentService.orderBy(field), HttpStatus.OK);
    }

    @GetMapping("/home/students/filterBy/{field}")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsFilteredBy(@PathVariable String field, @RequestParam String value) {
        return new ResponseEntity<>(studentService.filter(field, value), HttpStatus.OK);
    }

    @GetMapping("/home/universities/orderBy/{field}")
    @ResponseBody
    public ResponseEntity<List<University>> getUniversitiesOrderedBy(@PathVariable String field) {
        return new ResponseEntity<>(universityService.orderBy(field), HttpStatus.OK);
    }

    @GetMapping("/home/universities/filterBy/{field}")
    @ResponseBody
    public ResponseEntity<List<University>> getUniversitiesFilteredBy(@PathVariable String field, @RequestParam String value) {
        return new ResponseEntity<>(universityService.filter(field, value), HttpStatus.OK);
    }
}