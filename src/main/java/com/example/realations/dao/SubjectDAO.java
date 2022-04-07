package com.example.realations.dao;

import com.example.realations.model.Subject;
import com.example.realations.repository.SubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubjectDAO {

    SubjectRepository repository;

    public SubjectDAO(SubjectRepository repository) {
        this.repository = repository;
    }

    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    public Subject addSubject(Subject subject) {
        return repository.save(subject);
    }

    public Optional<Subject> findById(Integer subjectId) {
        return repository.findById(subjectId);
    }
}
