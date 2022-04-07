package com.example.realations.api;

import com.example.realations.model.Subject;
import com.example.realations.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Subject> getSubjects() {
        return service.getAllSubjects();
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return service.addSubject(subject);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Integer subjectId,
                                          @PathVariable Integer teacherId) {
        return service.assignTeacherToSubject(subjectId, teacherId);
    }

    @PutMapping("/{subjectId}/student/{studentId}")
    public Subject addStudentToSubject(@PathVariable Integer subjectId,
                                       @PathVariable Integer studentId) {
        return service.addStudentToSubject(subjectId, studentId);

    }
}
