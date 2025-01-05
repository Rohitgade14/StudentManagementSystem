package com.krios.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krios.student.exception.StudentNotFoundException;
import com.krios.student.payload.ApiResponse;
import com.krios.student.payload.StudentDto;
import com.krios.student.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto) {
		StudentDto createdStudent = this.studentService.createStudnet(studentDto);
		return new  ResponseEntity<>(createdStudent,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity <List<StudentDto>> getAllStudent() {
		 List<StudentDto> StudentList= this.studentService.getAllStudent();
		 return new ResponseEntity<>(StudentList,HttpStatus.OK);
		
	}
    @GetMapping ("/page")
	public ResponseEntity<Page<StudentDto>> getAllStudentByPage(	
			@RequestParam(defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(defaultValue = "5",required = false) Integer pageSize) {
	
             Page<StudentDto> studentPage =studentService.getAllStudentByPage(pageNumber, pageSize);
             return ResponseEntity.status(HttpStatus.OK).body(studentPage);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
    	    StudentDto student = this.studentService.getStudentById(id);
    	    return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable Integer id ) {
		try {
			StudentDto updateStudent = this.studentService.updateStudent(studentDto, id);
			return new ResponseEntity<>(updateStudent,HttpStatus.OK);
		} catch (StudentNotFoundException ex) {
	        return new ResponseEntity<>(new ApiResponse("Student not found with id " + id, false), HttpStatus.NOT_FOUND);
	    } 
		catch (Exception ex) {
	        return new ResponseEntity<>(new ApiResponse("An unexpected error occurred", false), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
			
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id){
		try {
			this.studentService.deleteStudent(id);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Student Deleted Succesfully",true),HttpStatus.OK);
		} 
		catch (StudentNotFoundException ex) {
			return new ResponseEntity<>(new ApiResponse("Student not found with id " + id, false), HttpStatus.NOT_FOUND);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(new ApiResponse("An unexpected error occurred", false), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	


}
