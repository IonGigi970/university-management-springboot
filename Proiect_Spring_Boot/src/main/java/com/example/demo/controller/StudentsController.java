package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;

@Controller
public class StudentsController {
        
        private StudentsService studentsService;

        public StudentsController(StudentsService studentsService) {
                super();
                this.studentsService = studentsService;
        }
        
        // Handler method to get list of students, return and display them
        @GetMapping("/students")
        public String listStudents(Model model) {
                model.addAttribute("students", studentsService.getAllStudents());
                return "students";
        }
        
        @GetMapping("/students/new")
        public String createStudentForm(Model model) {
                
                // Create student object to store form data
                Students student = new Students();
                model.addAttribute("student", student);
                return "addStudent";
                
        }
        
        @PostMapping("/students")
        public String saveStudent(@ModelAttribute("student") Students student) {
                studentsService.saveStudent(student);
                return "redirect:/students";
        }
        
        @GetMapping("/students/edit/{idstudent}")
        public String editStudentForm(@PathVariable Integer idstudent, Model model) {
                model.addAttribute("student", studentsService.getStudentById(idstudent));
                return "editStudent";
        }

        @PostMapping("/students/{idstudent}")
        public String updateStudent(@PathVariable Integer idstudent,
                        @ModelAttribute("student") Students student,
                        Model model) {
                
                // Get student from database by idstudent field
                Students existingStudent = studentsService.getStudentById(idstudent);
                existingStudent.setIdstudent(idstudent);
                existingStudent.setFirstName(student.getFirstName());
                existingStudent.setLastName(student.getLastName());
                existingStudent.setEmail(student.getEmail());
                existingStudent.setDateOfBirth(student.getDateOfBirth());
                existingStudent.setEnrollmentDate(student.getEnrollmentDate());
                existingStudent.setStudyYear(student.getStudyYear());
                
                // Save modified student object
                studentsService.updateStudent(existingStudent);
                return "redirect:/students";            
        }
        
        // Handler method used to handle student delete request
        @GetMapping("/students/{idstudent}")
        public String deleteStudent(@PathVariable Integer idstudent) {
                studentsService.deleteStudentById(idstudent);
                return "redirect:/students";
        }       
}
