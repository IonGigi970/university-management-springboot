package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Subjects;
import com.example.demo.service.SubjectsService;

@Controller
public class SubjectsController {
        
        private SubjectsService subjectsService;

        public SubjectsController(SubjectsService subjectsService) {
                super();
                this.subjectsService = subjectsService;
        }
        
        // Handler method to get list of subjects and display them
        @GetMapping("/subjects")
        public String listSubjects(Model model) {
                model.addAttribute("subjects", subjectsService.getAllSubjects());
                return "subjects";
        }
        
        @GetMapping("/subjects/new")
        public String createSubjectForm(Model model) {
                
                // Create subject object to store form data
                Subjects subject = new Subjects();
                model.addAttribute("subject", subject);
                return "addSubject";
                
        }
        
        @PostMapping("/subjects")
        public String saveSubject(@ModelAttribute("subject") Subjects subject) {
                subjectsService.saveSubject(subject);
                return "redirect:/subjects";
        }
        
        @GetMapping("/subjects/edit/{idsubject}")
        public String editSubjectForm(@PathVariable Integer idsubject, Model model) {
                model.addAttribute("subject", subjectsService.getSubjectById(idsubject));
                return "editSubject";
        }

        @PostMapping("/subjects/{idsubject}")
        public String updateSubject(@PathVariable Integer idsubject,
                        @ModelAttribute("subject") Subjects subject,
                        Model model) {
                
                // Get subject from database by idsubject field
                Subjects existingSubject = subjectsService.getSubjectById(idsubject);
                existingSubject.setIdsubject(idsubject);
                existingSubject.setSubjectName(subject.getSubjectName());
                existingSubject.setSubjectCode(subject.getSubjectCode());
                existingSubject.setCredits(subject.getCredits());
                existingSubject.setTopic(subject.getTopic());
                existingSubject.setSemester(subject.getSemester());
                
                // Save modified subject object
                subjectsService.updateSubject(existingSubject);
                return "redirect:/subjects";            
        }
        
        // Handler method used to handle subject delete request
        @GetMapping("/subjects/{idsubject}")
        public String deleteSubject(@PathVariable Integer idsubject) {
                subjectsService.deleteSubjectById(idsubject);
                return "redirect:/subjects";
        }       
}
