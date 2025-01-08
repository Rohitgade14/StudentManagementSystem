package com.krios.student.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.krios.student.entity.Category;
import com.krios.student.payload.CategoryDto;

import com.krios.student.repository.CategoryRepository;
import com.krios.student.service.CategoryService;

public class CategoryServiceImpl  implements CategoryService {
   
    private  CategoryRepository categoryRepository;

    @Autowired
	private ModelMapper modelMapper;

//	public List<StudentDto> getAllStudent() {
//		List<Student> students = this.studentRepository.findAll();
//		  List<StudentDto> studentDtos = students.stream()
//			.map(student ->this.StudentTodto(student)).collect(Collectors.toList());
//		return studentDtos;
//	}
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		  Category category =this.dtoToCategory(categoryDto);
		 Category savedCategory= this.categoryRepository.save(category);
		 return this.CategoryToDto(savedCategory);    
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CategoryDto> getCategories() {
               List<Category> Categories = this.categoryRepository.findAll();
               List<CategoryDto> categoryDtos =Categories.stream().map(cat )
		return null;
	}
	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public Category dtoToCategory(CategoryDto categoryDto) {
	     
		Category category =this.modelMapper.map(categoryDto, Category.class);
		return category;
	}
	public CategoryDto CategoryToDto(Category category) {
	    CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
	    return categoryDto;
	}

	

}
