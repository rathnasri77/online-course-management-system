package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.examly.springapp.model.Enrollment;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private List<Enrollment> enrollmentList = new ArrayList<>();

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        enrollmentList.add(enrollment);
        return enrollment;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentList;
    }

    @Override
    public Enrollment getEnrollmentById(int id) {
        for (Enrollment e : enrollmentList) {
            if (e.getEnrollmentId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Enrollment updateEnrollment(int id, Enrollment enrollment) {
        for (Enrollment e : enrollmentList) {
            if (e.getEnrollmentId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void deleteEnrollment(int id) {
        enrollmentList.removeIf(e -> e.getEnrollmentId() == id);
    }
}
