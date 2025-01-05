package com.krios.student.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.krios.student.payload.StudentDto;

public interface StudentService {
  
	StudentDto createStudnet(StudentDto studentDto);
    List<StudentDto> getAllStudent();
    StudentDto  getStudentById(Integer id);
    StudentDto updateStudent(StudentDto studentDto,Integer id);
    void deleteStudent(Integer id);
    Page<StudentDto> getAllStudentByPage(Integer pageNumber, Integer pageSize);

    
    
}
