package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SessionController {

	// public
	// String

	@GetMapping("signup")
	public String signup() {
		return "Signup";// jsp name
	}

//	@GetMapping("login")
	@GetMapping(value = { "login", "/" })
	public String login() {
		return "Login";
	}

//	@GetMapping("/")
//	public String welcome() {
//		return "Welcome";
//	}

	@PostMapping("saveuser")
	public String saveUser(String firstName,String lastName,String email,String password) {
		//input read 
		System.out.println(firstName);
		System.out.println(lastName);
		//validation 
		//db insertion 
		
		return "Login";
	}
	
	//

}
