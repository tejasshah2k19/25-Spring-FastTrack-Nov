package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBean;

@Controller
public class StudentController {

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
			model.addAttribute("result",result);
			return "NewStudent";
		} else {
			// send studentBean to Welcome.jsp
			model.addAttribute("studentBean", studentBean);
			return "Welcome";
		}
	}
}



