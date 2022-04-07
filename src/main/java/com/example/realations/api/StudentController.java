package com.example.realations.api;

import com.example.realations.dao.StudentDAO;
import com.example.realations.model.Student;
import com.example.realations.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
}
