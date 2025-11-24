package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBean;
import com.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@GetMapping("newstudent")
	public String newStudentReg() {
		return "NewStudent";
	}

	@PostMapping("savestudent")
	public String saveStudent(@Validated StudentBean studentBean, BindingResult result, Model model) {
		System.out.println(studentBean.getFirstName());
		System.out.println(studentBean.getLastName());
		System.out.println(studentBean.getEmail());
		System.out.println(studentBean.getPassword());

		if (result.hasErrors()) {
			model.addAttribute("result", result);
			return "NewStudent";
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(studentBean.getPassword());
			studentBean.setPassword(encodedPassword);
			// db insert
			studentDao.addStudent(studentBean);
			// send studentBean to Welcome.jsp
			model.addAttribute("studentBean", studentBean);
			return "Welcome";
		}
	}

	@GetMapping("liststudents")
	public String listStudent(Model model) {
		List<StudentBean> students = studentDao.getAllStudents();
		model.addAttribute("students",students);
		return "ListStudents";
	}
	
	@GetMapping("deletestudent")
	public String deleteStudent(Integer studentId,Model model) {
		//1 read student id 
		//2 deleteStudent -> StudentDao 
		//3 output -> response -> list page 
		studentDao.deleteStudent(studentId);
		List<StudentBean> students = studentDao.getAllStudents();
		model.addAttribute("students",students);
		
		return "ListStudents";
	}
	
	
	

}
