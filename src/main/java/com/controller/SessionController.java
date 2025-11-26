package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBean;
import com.dao.StudentDao;

@Controller
public class SessionController {

	// public
	// String
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	StudentDao studentDao;

	@GetMapping("signup")
	public String signup() {
		return "Signup";// jsp name
	}

//	@GetMapping("login")
	@GetMapping(value = { "login", "/" })
	public String login() {
		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(String email, String password) {
		StudentBean studentBean = studentDao.findByEmail(email);

		if (studentBean == null) {
			return "Login";
		} else {
			if (passwordEncoder.matches(password, studentBean.getPassword()) == true) {
				return "Home";
			} else {
				return "Login";
			}
		}

	}

//	@GetMapping("/")
//	public String welcome() {
//		return "Welcome";
//	}

	@PostMapping("saveuser")
	public String saveUser(String firstName, String lastName, String email, String password) {
		// input read
		System.out.println(firstName);
		System.out.println(lastName);
		// validation
		// db insertion

		return "Login";
	}

	//

}
