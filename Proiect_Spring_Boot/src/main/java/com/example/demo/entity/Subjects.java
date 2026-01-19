package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idsubject;

	@Column(name = "subject_name", nullable = false)
	private String subjectName;

	@Column(name = "subject_code", nullable = false)
	private String subjectCode;

	@Column(name = "credits")
	private Short credits;

	@Column(name = "topic")
	private String topic;

	@Column(name = "semester")
	private Byte semester;
	
	@OneToMany(mappedBy="subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Enrollments> enrollments;

	public Subjects() {

	}

	public Subjects(String subjectName, String subjectCode, Short credits, String topic, Byte semester) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.credits = credits;
		this.topic = topic;
		this.semester = semester;
	}

	public void addSubject(String subjectName, String subjectCode, Short credits, String topic, Byte semester) {
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.credits = credits;
		this.topic = topic;
		this.semester = semester;
	}

	public Integer getIdsubject() {
		return idsubject;
	}

	public void setIdsubject(Integer idsubject) {
		this.idsubject = idsubject;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Short getCredits() {
		return credits;
	}

	public void setCredits(Short credits) {
		this.credits = credits;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Byte getSemester() {
		return semester;
	}

	public void setSemester(Byte semester) {
		this.semester = semester;
	}

	public Set<Enrollments> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(Set<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}
}
