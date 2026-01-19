package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.service.StudentsService;

@Service
public class StudentsServiceImpl implements StudentsService{

	private StudentsRepository studentsRepository;
	
	public StudentsServiceImpl(StudentsRepository studentsRepository) {
		super();
		this.studentsRepository = studentsRepository;
	}

	@Override
	public List<Students> getAllStudents() {
		return studentsRepository.findAll();
	}

	@Override
	@Transactional
	public Students saveStudent(Students student) {
		return studentsRepository.save(student);
	}

	@Override
	public Students getStudentById(Integer idstudent) {
		return studentsRepository.findById(idstudent).get();
	}

	@Override
	public Students updateStudent(Students student) {
		return studentsRepository.save(student);
	}

	@Override
	public void deleteStudentById(Integer idstudent) {
		studentsRepository.deleteById(idstudent);	
	}
}
