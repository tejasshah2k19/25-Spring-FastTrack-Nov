package com.bean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StudentBean {

	Integer studentId; 
	
	@NotBlank(message = "Please Enter FirstName")
	@Size(min = 2,message = "Please Enter Valid name - atleast 2 char")
	@Size(max = 50,message = "Please Enter Valid name - max 50 char")
	private String firstName;

	@NotBlank(message = "Please Enter LastName")
	@Pattern(regexp = "[a-zA-Z]+",message = "Please Enter Valid LastName") // + => min:1 max:n 
	private String lastName;

	@NotBlank
//	@Email(message = "Please Enter Valid") // XXX@XX   XX@XX.XX 
	
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}",message = "Please Enter Valid Email")
	private String email;

	@NotBlank
	private String password;
	
	@Min(value = 1,message = "Please Enter Valid Age")
	private Integer age; 
	
//	@Pattern(regexp = "[0-9]+")//digit 
//	@Pattern(regexp = "[0-9a-zA-Z]+")//alnum
//	@Pattern(regexp = "[0-9a-zA-Z_@]+")//digit 
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	

}
