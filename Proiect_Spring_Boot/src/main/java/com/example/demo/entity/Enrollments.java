package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idenrollment;
	
	@ManyToOne
	@JoinColumn(name = "idsubject", nullable = false)
	private Subjects subject;
	
	@ManyToOne
	@JoinColumn(name = "idstudent", nullable = false)
	private Students student;

	@Column(name = "academic_year", nullable = false)
	private String academicYear;

	@Column(name = "final_grade")
	private BigDecimal finalGrade;

	@Column(name = "enrollment_date")
	private Date enrollmentDate;

	public Enrollments() {

	}

	public Enrollments(Students student, Subjects subject, String academicYear, BigDecimal finalGrade, Date enrollmentDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.academicYear = academicYear;
		this.finalGrade = finalGrade;
		this.enrollmentDate = enrollmentDate;
	}

	public void addEnrollment(Integer idstudent, Integer idsubject, String academicYear, BigDecimal finalGrade, Date enrollmentDate) {
		this.academicYear = academicYear;
		this.finalGrade = finalGrade;
		this.enrollmentDate = enrollmentDate;
	}

	public Integer getIdenrollment() {
		return this.idenrollment;
	}

	public void setIdenrollment(Integer idenrollment) {
		this.idenrollment = idenrollment;
	}

	public Subjects getSubject() {
		return this.subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Students getStudent() {
		return this.student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	public String getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public BigDecimal getFinalGrade() {
		return this.finalGrade;
	}

	public void setFinalGrade(BigDecimal finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	public Date getEnrollmentDate() {
		return this.enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
}
