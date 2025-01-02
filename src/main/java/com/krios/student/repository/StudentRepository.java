package com.krios.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krios.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
