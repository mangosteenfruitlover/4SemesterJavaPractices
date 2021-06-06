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
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/create-university", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<University> createUniversity(@RequestBody University university) {
        universityService.save(university);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/student/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        studentService.delete(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/university/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<University> deleteUniversity(@PathVariable("id") Long id) {
        University university = universityService.getById(id);
        universityService.delete(id);
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

    @GetMapping("/home/students/filterBy/firstName/{value}")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsFilteredByFirstName(@PathVariable String value) {
        return new ResponseEntity<>(studentService.findAllByFirstName(value), HttpStatus.OK);
    }

    @GetMapping("/home/students/filterBy/middleName/{value}")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsFilteredByMiddleName(@PathVariable String value) {
        return new ResponseEntity<>(studentService.findAllByMiddleName(value), HttpStatus.OK);
    }

    @GetMapping("/home/students/filterBy/lastName/{value}")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsFilteredByLastName(@PathVariable String value) {
        return new ResponseEntity<>(studentService.findAllByLastName(value), HttpStatus.OK);
    }

    @GetMapping("/home/universities/filterBy/name/{value}")
    @ResponseBody
    public ResponseEntity<List<University>> getUniversitiesByName(@PathVariable String value) {
        return new ResponseEntity<>(universityService.findAllByName(value), HttpStatus.OK);
    }

    @GetMapping("/home/universities/filterBy/creationDate/{value}")
    @ResponseBody
    public ResponseEntity<List<University>> getUniversitiesByCreationDate(@PathVariable String value) {
        return new ResponseEntity<>(universityService.findAllByCreationDate(value), HttpStatus.OK);
    }


    @GetMapping("/home/students/orderBy/firstName")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsSortedByFirstName() {
        return new ResponseEntity<>(studentService.getAllSortedBy("firstName"), HttpStatus.OK);
    }

    @GetMapping("/home/students/orderBy/middleName")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsSortedByMiddleName() {
        return new ResponseEntity<>(studentService.getAllSortedBy("middleName"), HttpStatus.OK);
    }

    @GetMapping("/home/students/orderBy/lastName")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsSortedByLastName() {
        return new ResponseEntity<>(studentService.getAllSortedBy("lastName"), HttpStatus.OK);
    }


    @GetMapping("/home/universities/orderBy/name")
    @ResponseBody
    public ResponseEntity<List<University>> getUniversitiesSortedByName() {
        return new ResponseEntity<>(universityService.getAllSortedBy("name"), HttpStatus.OK);
    }

    @GetMapping("/home/universities/orderBy/creationDate")
    @ResponseBody
    public ResponseEntity<List<University>> getUniversitiesSortedByCreationDate() {
        return new ResponseEntity<>(universityService.getAllSortedBy("creationDate"), HttpStatus.OK);
    }
}