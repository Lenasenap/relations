package com.example.realations.service;

import com.example.realations.dao.StudentDAO;
import com.example.realations.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudent();
    }

    public Student addStudent(Student student) {
        return studentDAO.saveStudent(student);
    }
}
