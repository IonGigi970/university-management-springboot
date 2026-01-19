package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Enrollments;

public interface EnrollmentsRepository extends JpaRepository<Enrollments, Integer>{

}
