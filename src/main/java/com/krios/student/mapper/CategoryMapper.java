package com.krios.student.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CategoryMapper {
	@Bean
	public ModelMapper modelMapper() {
	
		return new ModelMapper();
		
	}
}