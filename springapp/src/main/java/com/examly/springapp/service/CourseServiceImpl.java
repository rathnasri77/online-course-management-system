package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        Optional<Course> course = courseRepo.findById(id);
        return course.orElse(null);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        Optional<Course> existing = courseRepo.findById(id);
        if (existing.isPresent()) {
            Course c = existing.get();
            c.setCourseName(course.getCourseName());
            c.setDescription(course.getDescription());
            c.setDuration(course.getDuration());
            c.setPrice(course.getPrice());
            c.setLevel(course.getLevel());
            c.setInstructor(course.getInstructor());
            return courseRepo.save(c);
        }
        return null;
    }

    @Override
    public List<Course> getCoursesByLevel(String level) {
        return courseRepo.findByLevel(level);
    }

    @Override
    public List<Course> getCoursesByInstructor(int instructorId) {
        return courseRepo.findByInstructorInstructorId(instructorId);
    }
}
