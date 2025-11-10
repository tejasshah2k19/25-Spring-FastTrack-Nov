package com.bean;

import jakarta.validation.constraints.NotBlank;

public class StudentBean {

	@NotBlank(message = "Please Enter FirstName")
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String email;

	@NotBlank
	private String password;

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

}
