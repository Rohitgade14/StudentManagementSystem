package com.krios.student.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class StudentMapper  {
	@Bean
	public ModelMapper modelMapper() {
	
		return new ModelMapper();
		
	}

}
