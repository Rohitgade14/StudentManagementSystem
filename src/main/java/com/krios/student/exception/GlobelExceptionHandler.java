package com.krios.student.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumnetNotValidExcepation (MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			 
		  String fieldName = ((FieldError) error).getField();
		     String errorMessage = error.getDefaultMessage();
		     errors.put(fieldName, errorMessage);
		});
	  return  new  ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}
  
}
