package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> addInstructor(@RequestBody(required = false) Instructor instructor) {
        if (instructor == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(instructorService.saveInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        List<Instructor> list = instructorService.getAllInstructors();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable int id) {
        return instructorService.getInstructorById(id);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable int id) {}

    @GetMapping("/page/{page}/{size}")
    public Page<Instructor> getInstructorPage(@PathVariable int page, @PathVariable int size) {
        return instructorService.getInstructorPage(page, size);
    }

    @GetMapping("/specialization/{spec}")
    public ResponseEntity<?> getBySpecialization(@PathVariable String spec) {
        List<Instructor> list = instructorService.getBySpecialization(spec);
        if (list.isEmpty()) {
            return ResponseEntity.status(404)
                    .body("No instructors found with specialization: " + spec);
        }
        return ResponseEntity.ok(list);
    }
}
