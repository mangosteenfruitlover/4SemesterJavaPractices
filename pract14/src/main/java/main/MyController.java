package main;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {
    private List<Student> students = new ArrayList<>();
    private List<University> universities = new ArrayList<>();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "test.html";
    }

    @RequestMapping(value = "/home/create-university", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void createUniversity(@RequestBody University university) {
        universities.add(university);
    }

    @RequestMapping(value = "/home/create-student", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void createStudent(@RequestBody Student student) {
        students.add(student);
    }

    @RequestMapping(value = "/home/get-students", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents() {
        return students;
    }

    @RequestMapping(value = "/home/get-universities", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<University> getUniversities() {
        return universities;
    }

    @RequestMapping(value = "/home/remove-students", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void removeStudents() {
        students.clear();
    }

    @RequestMapping(value = "/home/remove-universities", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void removeUniversities() {
        universities.clear();
    }
}
