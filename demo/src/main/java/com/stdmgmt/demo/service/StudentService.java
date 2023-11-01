package com.stdmgmt.demo.service;

import java.util.List;

import com.stdmgmt.demo.entity.Student;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student saveStudent(Student newStudent);

    public Student updateStudent(Student student);

    public Student getStudentById(Long id);

    public void deleteStudentById(Long id);
}
