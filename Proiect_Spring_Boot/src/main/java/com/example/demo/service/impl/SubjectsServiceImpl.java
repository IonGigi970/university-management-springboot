package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Subjects;
import com.example.demo.repository.SubjectsRepository;
import com.example.demo.service.SubjectsService;

@Service
public class SubjectsServiceImpl implements SubjectsService{

	private SubjectsRepository subjectsRepository;
	
	public SubjectsServiceImpl(SubjectsRepository subjectsRepository) {
		super();
		this.subjectsRepository = subjectsRepository;
	}

	@Override
	public List<Subjects> getAllSubjects() {
		return subjectsRepository.findAll();
	}

	@Override
	@Transactional
	public Subjects saveSubject(Subjects subject) {
		return subjectsRepository.save(subject);
	}

	@Override
	public Subjects getSubjectById(Integer idsubject) {
		return subjectsRepository.findById(idsubject).get();
	}

	@Override
	public Subjects updateSubject(Subjects subject) {
		return subjectsRepository.save(subject);
	}

	@Override
	public void deleteSubjectById(Integer idsubject) {
		subjectsRepository.deleteById(idsubject);	
	}
}
