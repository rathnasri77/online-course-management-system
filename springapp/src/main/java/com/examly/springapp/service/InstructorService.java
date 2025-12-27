package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.Instructor;

public interface InstructorService {

    Instructor saveInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(int id);

    Instructor updateInstructor(int id, Instructor instructor);

    Page<Instructor> getInstructorPage(int page, int size);

    List<Instructor> getBySpecialization(String specialization);
}
