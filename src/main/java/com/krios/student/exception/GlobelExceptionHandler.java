package com.krios.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.krios.student.payload.ApiResponse;

@RestControllerAdvice
public class GlobelExceptionHandler {
	
  @ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ApiResponse> StudentNotFoundExceptionHandler(StudentNotFoundException ex) {
		String message =ex.getMessage();
		ApiResponse apiResponse= new ApiResponse(message,false);
	  return new  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
    
}
