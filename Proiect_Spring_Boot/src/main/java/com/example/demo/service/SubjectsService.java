package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subjects;

public interface SubjectsService {
	List<Subjects> getAllSubjects();
	
	Subjects saveSubject(Subjects subject);
	
	Subjects getSubjectById(Integer idsubject);
	
	Subjects updateSubject(Subjects subject);
	
	void deleteSubjectById(Integer idsubject);
}
