package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.StudentBean;
import com.cloudinary.Cloudinary;
import com.dao.StudentDao;
import com.service.MailService;

@Controller
public class StudentController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	Cloudinary cloudinary;

	@Autowired
	StudentDao studentDao;

	@Autowired
	MailService mailService;

	@GetMapping("newstudent")
	public String newStudentReg() {
		return "NewStudent";
	}

	// 100
	@PostMapping("savestudent")
	public String saveStudent(@Validated StudentBean studentBean, BindingResult result, Model model,
			MultipartFile profilePic) {
		// assets
		// images
		// aws s3 bucket

		// cloudinary
		System.out.println(studentBean.getFirstName());
		System.out.println(studentBean.getLastName());
		System.out.println(studentBean.getEmail());
		System.out.println(studentBean.getPassword());

		System.out.println(profilePic.getOriginalFilename());
		System.out.println(profilePic.getSize());

		if (result.hasErrors()) {
			model.addAttribute("result", result);
			return "NewStudent";
		} else {
			String encodedPassword = passwordEncoder.encode(studentBean.getPassword());
			studentBean.setPassword(encodedPassword);
			// db insert
			// studentDao.addStudent(studentBean);
			// send welcome mail to student
			// mailService.sendWelcomeMail(studentBean);
			try {
				 Map uploadResult = 	cloudinary.uploader().upload(profilePic.getBytes(), null);
				String profilePicURL =  uploadResult.get("secure_url").toString();
				System.out.println(profilePicURL);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			// send studentBean to Welcome.jsp
			model.addAttribute("studentBean", studentBean);
			return "Welcome";
		}
	}

	@GetMapping("liststudents")
	public String listStudent(Model model) {
		List<StudentBean> students = studentDao.getAllStudents();
		model.addAttribute("students", students);
		return "ListStudents";
	}

	@GetMapping("deletestudent")
	public String deleteStudent(Integer studentId, Model model) {
		// 1 read student id
		// 2 deleteStudent -> StudentDao
		// 3 output -> response -> list page
		studentDao.deleteStudent(studentId);
		List<StudentBean> students = studentDao.getAllStudents();
		model.addAttribute("students", students);

		return "ListStudents";
	}

}
