package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Enrollments;
import com.example.demo.repository.EnrollmentsRepository;
import com.example.demo.service.EnrollmentsService;


@Service
public class EnrollmentsServiceImpl implements EnrollmentsService{

	private EnrollmentsRepository enrollmentsRepository;
	
	public EnrollmentsServiceImpl(EnrollmentsRepository enrollmentsRepository) {
		super();
		this.enrollmentsRepository = enrollmentsRepository;
	}

	@Override
	public List<Enrollments> getAllEnrollments() {
		return enrollmentsRepository.findAll();
	}

	@Override
	@Transactional
	public Enrollments saveEnrollment(Enrollments enrollment) {
		return enrollmentsRepository.save(enrollment);
	}

	@Override
	public Enrollments getEnrollmentById(Integer idenrollment) {
		return enrollmentsRepository.findById(idenrollment).get();
	}

	@Override
	public Enrollments updateEnrollment(Enrollments enrollment) {
		return enrollmentsRepository.save(enrollment);
	}

	@Override
	public void deleteEnrollmentById(Integer idenrollment) {
		enrollmentsRepository.deleteById(idenrollment);	
	}
}
