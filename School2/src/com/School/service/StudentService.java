package com.School.service;

import java.sql.SQLException;
import java.util.List;

import com.School.bo.StudentBO;
import com.School.dao.StudentDao;

public class StudentService {

	public Boolean saveStudent(StudentBO studentBO) throws SQLException{
		StudentDao StudentDao=new StudentDao();
		return StudentDao.saveStudent(studentBO);
		
	}

	public List<StudentBO> getStudentList() throws SQLException {
		StudentDao studentDao=new StudentDao();
		return studentDao.getStudentList();
	}

}
