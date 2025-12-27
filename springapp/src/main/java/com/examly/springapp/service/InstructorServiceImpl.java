package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepo.findById(id).orElse(null);
    }

    @Override
    public Instructor updateInstructor(int id, Instructor instructor) {
        instructor.setInstructorId(id);
        return instructorRepo.save(instructor);
    }

    @Override
    public Page<Instructor> getInstructorPage(int page, int size) {
        return instructorRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Instructor> getBySpecialization(String specialization) {
        return instructorRepo.findBySpecialization(specialization);
    }
}
