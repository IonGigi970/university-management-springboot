package com.example.demo.entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idstudent;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "enrollment_date")
	private Date enrollmentDate;

	@Column(name = "study_year")
	private Byte studyYear;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Enrollments> enrollments;

	public Students() {

	}

	public Students(String firstName, String lastName, String email, Date dateOfBirth, Date enrollmentDate, Byte studyYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.enrollmentDate = enrollmentDate;
		this.studyYear = studyYear;
	}

	public void addStudent(String firstName, String lastName, String email, Date dateOfBirth, Date enrollmentDate, Byte studyYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.enrollmentDate = enrollmentDate;
		this.studyYear = studyYear;
	}

	public Integer getIdstudent() {
		return idstudent;
	}

	public void setIdstudent(Integer idstudent) {
		this.idstudent = idstudent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Byte getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(Byte studyYear) {
		this.studyYear = studyYear;
	}

	public Set<Enrollments> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(Set<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}
}
