package com.example.realations.api;

import com.example.realations.model.Subject;
import com.example.realations.model.Teacher;
import com.example.realations.service.SubjectService;
import com.example.realations.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return service.getAllTeachers();
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return service.addTeacher(teacher);
    }

}
