package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Enrollments;
import com.example.demo.service.EnrollmentsService;

import com.example.demo.entity.Students;
import com.example.demo.repository.SubjectsRepository;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.entity.Subjects;

@Controller
public class EnrollmentsController {
        
        private EnrollmentsService enrollmentsService;
        
        @Autowired
        private StudentsRepository studentsRepo;
        
        @Autowired
        private SubjectsRepository subjectsRepo;

        public EnrollmentsController(EnrollmentsService enrollmentsService) {
                super();
                this.enrollmentsService = enrollmentsService;
        }
        
        // Handler method to get list of enrollments and display them
        @GetMapping("/enrollments")
        public String listEnrollments(Model model) {
                model.addAttribute("enrollments", enrollmentsService.getAllEnrollments());
                return "enrollments";
        }
        
        @GetMapping("/enrollments/new")
        public String createEnrollmentForm(Model model) {
                List<Students> allStudents = studentsRepo.findAll();
                List<Subjects> allSubjects = subjectsRepo.findAll();
                
                // Create enrollment object to store form data
                Enrollments enrollment = new Enrollments();
                model.addAttribute("enrollment", enrollment);
                
                model.addAttribute("allStudents", allStudents);
                model.addAttribute("allSubjects", allSubjects);
                
                return "addEnrollment";
                
        }
        
        @PostMapping("/enrollments")
        public String saveEnrollment(@ModelAttribute("enrollment") Enrollments enrollment) {            
                enrollmentsService.saveEnrollment(enrollment);
                return "redirect:/enrollments";
        }
        
        @GetMapping("/enrollments/edit/{idenrollment}")
        public String editEnrollmentForm(@PathVariable Integer idenrollment, Model model) {
                List<Students> allStudents = studentsRepo.findAll();
                List<Subjects> allSubjects = subjectsRepo.findAll();

                model.addAttribute("enrollment", enrollmentsService.getEnrollmentById(idenrollment));
                model.addAttribute("allStudents", allStudents);
                model.addAttribute("allSubjects", allSubjects);
                
                return "editEnrollment";
        }

        @PostMapping("/enrollments/{idenrollment}")
        public String updateEnrollment(@PathVariable Integer idenrollment,
                        @ModelAttribute("enrollment") Enrollments enrollment,
                        Model model) {
                
                // Get enrollment from database by idenrollment field
                Enrollments existingEnrollment = enrollmentsService.getEnrollmentById(idenrollment);
                existingEnrollment.setIdenrollment(idenrollment);
                existingEnrollment.setStudent(enrollment.getStudent());
                existingEnrollment.setSubject(enrollment.getSubject());
                existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
                existingEnrollment.setAcademicYear(enrollment.getAcademicYear());
                existingEnrollment.setFinalGrade(enrollment.getFinalGrade());

                // Save modified enrollment object
                enrollmentsService.updateEnrollment(existingEnrollment);
                return "redirect:/enrollments";         
        }
        
        // Handler method used to handle enrollment delete request
        @GetMapping("/enrollments/{idenrollment}")
        public String deleteEnrollment(@PathVariable Integer idenrollment) {
                enrollmentsService.deleteEnrollmentById(idenrollment);
                return "redirect:/enrollments";
        }       
}
