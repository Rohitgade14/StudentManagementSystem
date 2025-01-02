package com.krios.student.serviceimpl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krios.student.entity.Student;
import com.krios.student.exception.StudentNotFoundException;
import com.krios.student.payload.StudentDto;
import com.krios.student.repository.StudentRepository;
import com.krios.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
    @Autowired
	private ModelMapper modelMapper;

	public StudentDto createStudnet(StudentDto studentDto) {
		Student student =this.dtoToStudent(studentDto);
		Student savedStudent = this.studentRepository.save(student);
		return this.StudentTodto(savedStudent);
	}

	
	public List<StudentDto> getAllStudent() {
		List<Student> students = this.studentRepository.findAll();
		  List<StudentDto> studentDtos = students.stream()
			.map(student ->this.StudentTodto(student)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDto getStudentById(Integer id) {
	         Student student = this.studentRepository.findById(id)
	         .orElseThrow(()-> new StudentNotFoundException("Student not found with id"+id));
	         
		return this.StudentTodto(student);
	}


	public StudentDto updateStudent(StudentDto studentDto, Integer id) {
		Student student =this.studentRepository.findById(id).
				orElseThrow(() -> new StudentNotFoundException("Student not found with id"+id));
				
				student.setName(studentDto.getName());
				student.setEmail(studentDto.getEmail());
				student.setPassword(studentDto.getPassword());
				student.setAbout(studentDto.getAbout());
				
				Student updatedStudent = this.studentRepository.save(student);
				 return this.StudentTodto(updatedStudent);
	}


	
	public void deleteStudent(Integer id) {
		
		Student student = this.studentRepository.findById(id)
		.orElseThrow(() -> new StudentNotFoundException("Student not Found with id"+id));
		
		this.studentRepository.delete(student);
		
	}
	
	public Student dtoToStudent(StudentDto studentDto) {
      
		Student student =this.modelMapper.map(studentDto, Student.class);
		return student;
//		student.setName(studentDto.getName());
//		student.setEmail(studentDto.getEmail());
//		student.setPassword(studentDto.getPassword());
//		student.setAbout(studentDto.getAbout());
	
	}
	public StudentDto StudentTodto(Student student) {
		
		StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
		return studentDto;
//		StudentDto studentDto = new StudentDto();
//		studentDto.setId(student.getId());
//		studentDto.setName(student.getName());
//		studentDto.setEmail(student.getEmail());
//		studentDto.setPassword(student.getPassword());
//		studentDto.setAbout(student.getAbout());
		
		
	}




//	@Override
//	public void getAllStudentByPage(Integer pageNumber, Integer pageSize) {
//		// TODO Auto-generated method stub
//		
//	}


	
	

}
