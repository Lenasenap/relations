package com.example.realations.service;

import com.example.realations.dao.StudentDAO;
import com.example.realations.dao.SubjectDAO;
import com.example.realations.dao.TeacherDAO;
import com.example.realations.model.Student;
import com.example.realations.model.Subject;
import com.example.realations.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    SubjectDAO subjectDAO;
    TeacherDAO teacherDAO;
    StudentDAO studentDAO;

    public SubjectService(SubjectDAO subjectDAO,
                          TeacherDAO teacherDAO,
                          StudentDAO studentDAO) {
        this.subjectDAO = subjectDAO;
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
    }

    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }

    public Subject addSubject(Subject subject) {
        return subjectDAO.addSubject(subject);
    }

    public Subject assignTeacherToSubject(Integer subjectId, Integer teacherId) {
        Optional<Subject> maybeSubject = subjectDAO.findById(subjectId);
        Optional<Teacher> maybeTeacher = teacherDAO.findById(teacherId);

        if(maybeSubject.isEmpty() || maybeTeacher.isEmpty()) {
            return null;
        }

        Subject subject = maybeSubject.get();
        Teacher teacher = maybeTeacher.get();

        subject.setTeacher(teacher);
        return subjectDAO.addSubject(subject);
    }

    public Subject addStudentToSubject(Integer subjectId, Integer studentId) {
        Optional<Subject> maybeSubject = subjectDAO.findById(subjectId);
        Optional<Student> maybeStudent = studentDAO.findById(studentId);

        if (maybeSubject.isEmpty() || maybeStudent.isEmpty()) {
            return null;
        }

        Subject subject = maybeSubject.get();
        Student student = maybeStudent.get();

        List<Student> students = subject.getStudents();
        students.add(student);

        subject.setStudents(students);

        return subjectDAO.addSubject(subject);
    }
}
