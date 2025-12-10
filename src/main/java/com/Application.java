package com;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// spring bean -> spring -> singleton

	@Bean // single time
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();// single
	}

	@Bean
	Cloudinary getCloudinary() {
		Map<String, String> config = ObjectUtils.asMap("cloud_name", "dqwes5eev", "api_key", "781758332318518",
				"api_secret", "hr2hMchu6JApgB9ECnaoCfUZ_0I");
		return new Cloudinary(config);
	}

}
