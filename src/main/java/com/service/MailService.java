package com.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bean.StudentBean;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	JavaMailSender mailSender;// singleton

//	public void sendWelcomeMail(StudentBean student) {
//		//logic 
//		SimpleMailMessage message =new SimpleMailMessage();
//		message.setTo(student.getEmail());
//		message.setSubject("Welcome mail");
//		message.setText("Welcome to alibaba.com , we are happy to onboard you");
//		mailSender.send(message);
//	}

	public void sendWelcomeMail(StudentBean student) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setTo(student.getEmail());
			helper.setSubject("Welcome to Our Platform!");

			String path = "src/main/resources/templates/WelcomeMail.html";
			Path p = Paths.get(path);
			String htmlMsg = new String(Files.readAllBytes(p));
			
			htmlMsg = htmlMsg.replace("${firstName}", student.getFirstName());
			
			helper.setText(htmlMsg, true);

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
