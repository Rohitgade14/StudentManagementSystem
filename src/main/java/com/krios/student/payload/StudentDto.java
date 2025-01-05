package com.krios.student.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDto {
	
	 private Integer id;
	
	  @NotBlank(message = "Name cannot be blanks")
	  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	  private String name;
	
	  @Email(message = "Please provide a valid email address")
	  @NotBlank(message = "Email cannot be blank")
	  private String email;
	 
	  @NotBlank(message = "Password cannot be blank")
	    @Size(min = 8, message = "Password must be at least 8 characters long")
	  @Pattern(
      regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])[A-Za-z\\d@#$%^&+=]{8,}$",
	 message = "Password must start with an uppercase letter, include at least one special character, one number, and be at least 8 characters long"
		    )
	  private String password;
	 
	   @NotBlank(message = "Address is required")
	   @Size(max = 200, message = "Address cannot exceed 200 characters")
	   private String about;
}
