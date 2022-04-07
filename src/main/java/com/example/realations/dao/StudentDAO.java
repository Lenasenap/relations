package com.example.realations.dao;

import com.example.realations.model.Student;
import com.example.realations.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAO {
    StudentRepository repository;

    public StudentDAO(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> findById(Integer studentId) {
        return repository.findById(studentId);
    }
}
