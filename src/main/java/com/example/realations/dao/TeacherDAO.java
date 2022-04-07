package com.example.realations.dao;

import com.example.realations.model.Teacher;
import com.example.realations.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherDAO {

    TeacherRepository repository;

    public TeacherDAO(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    public Optional<Teacher> findById(Integer teacherId) {
        return repository.findById(teacherId);
    }
}
