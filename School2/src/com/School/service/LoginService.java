package com.School.service;

import java.sql.SQLException;

import com.School.bo.LoginBO;
import com.School.dao.LoginDao;

public class LoginService {

	public Boolean checkLogin(LoginBO login) throws SQLException {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDao();
		return loginDao.checkLogin(login);
	}

	

}
