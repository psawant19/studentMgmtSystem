package com.stdmgmt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stdmgmt.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
