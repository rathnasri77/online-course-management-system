package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @GetMapping("/{id}")
    public String getEnrollmentById(@PathVariable int id) {
        return "Enrollment " + id;
    }
}
