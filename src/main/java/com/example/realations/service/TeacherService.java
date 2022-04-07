package com.example.realations.service;

import com.example.realations.dao.TeacherDAO;
import com.example.realations.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    TeacherDAO teacherDAO;

    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherDAO.saveTeacher(teacher);
    }
}
