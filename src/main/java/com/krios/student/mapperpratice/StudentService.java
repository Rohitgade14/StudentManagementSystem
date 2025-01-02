//package com.krios.student.mapperpratice;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//    public Student saveStudent(StudentDto studentDto) {
//        // Convert DTO to Entity
//        Student student = studentMapper.dtoToStudent(studentDto);
//
//        // Logic to save the student (repository call)
//        // Example: studentRepository.save(student);
//
//        return student;
//    }
//
//    public StudentDto getStudentById(Long id) {
//        // Logic to fetch student (repository call)
//        // Example: Student student = studentRepository.findById(id).orElseThrow(...);
//
//        Student student = new Student(); // Replace with repository call
//        student.setId(id);
//        student.setName("John Doe");
//
//        // Convert Entity to DTO
//        return studentMapper.studentToDto(student);
//    }
//}
