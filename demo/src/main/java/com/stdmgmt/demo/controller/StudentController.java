package com.stdmgmt.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stdmgmt.demo.entity.Student;
import com.stdmgmt.demo.service.StudentService;

//This class handles all the operations with the student table
@Controller
public class StudentController {

    StudentService studentService;

    StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String getAllStudents(Model m) {
        m.addAttribute("student", studentService.getAllStudents());
        return "student";
    }

    @GetMapping("/student/new")
    public String addNewStudent(Model m) {
        Student std = new Student();
        m.addAttribute("newStudent", std);
        return "createStudent";
    }

    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("newStudent") Student newStudent) {
        studentService.saveStudent(newStudent);
        return "redirect:/student";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable Long id, Model m) {
        m.addAttribute("editStudent", studentService.getStudentById(id));
        return "editStudent";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("editStudent") Student updtStudent,
            Model m) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFname(updtStudent.getFname());
        existingStudent.setLname(updtStudent.getLname());
        existingStudent.setEmail(updtStudent.getEmail());
        existingStudent.setId(id);

        studentService.updateStudent(existingStudent);
        return "redirect:/student";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }
}
