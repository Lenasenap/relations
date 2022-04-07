package com.example.realations.service;

import com.example.realations.dao.StudentDAO;
import com.example.realations.model.Student;
import com.example.realations.model.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest extends MockitoExtension {

    static StudentService unitUnderTest;
    static StudentDAO studentDAO;

    @BeforeAll
    public static void init() {
        studentDAO = Mockito.mock(StudentDAO.class);
        unitUnderTest = new StudentService(studentDAO);
    }

    @Test
    void getAllStudents() {
        // Setup
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Nova");
        student1.setSubjects(List.of(new Subject()));

        List<Student> studentsFromDB = List.of(student1);
        Mockito.when(studentDAO.getAllStudent()).thenReturn(studentsFromDB);

        // Test
        List<Student> actualListOfStudents = unitUnderTest.getAllStudents();

        // Verify
        assertEquals("Nova", actualListOfStudents.get(0).getName());
    }

    @Test
    void addStudent() {
    }
}