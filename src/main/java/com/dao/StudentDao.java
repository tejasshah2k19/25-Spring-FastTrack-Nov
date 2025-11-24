package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<StudentBean> getAllStudents() {
		String q = "select * from students";
		List<StudentBean> students = stmt.query(q, new BeanPropertyRowMapper(StudentBean.class));
		return students;
	}

	//delete from students where studentId = XX 
	public void deleteStudent(Integer studentId){
		stmt.update("delete from students where studentId = ?",studentId);
	}
}
