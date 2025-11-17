package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate stmt;

	public void addStudent(StudentBean studentBean) {
		stmt.update("insert into students (firstName,lastName,email,password,age) values (?,?,?,?,?)",
				studentBean.getFirstName(), studentBean.getLastName(), studentBean.getEmail(),
				studentBean.getPassword(), studentBean.getAge());
	}

}
