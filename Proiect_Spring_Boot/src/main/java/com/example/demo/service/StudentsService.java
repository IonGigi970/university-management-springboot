package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Students;

public interface StudentsService {
	List<Students> getAllStudents();
	
	Students saveStudent(Students student);
	
	Students getStudentById(Integer idstudent);
	
	Students updateStudent(Students student);
	
	void deleteStudentById(Integer idstudent);
}
