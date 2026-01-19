package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Enrollments;

public interface EnrollmentsService {
	List<Enrollments> getAllEnrollments();
	
	Enrollments saveEnrollment(Enrollments enrollment);
	
	Enrollments getEnrollmentById(Integer idenrollment);
	
	Enrollments updateEnrollment(Enrollments enrollment);
	
	void deleteEnrollmentById(Integer idenrollment);
}
