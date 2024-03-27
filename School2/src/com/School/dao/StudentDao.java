package com.School.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.School.bo.StudentBO;

public class StudentDao {
  public Boolean saveStudent(StudentBO studentBO) throws SQLException{
	  boolean value=false;
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school2db", "root", "admin");
		Statement statement=con.createStatement();
		String insert = "INSERT INTO student (studentName, emailAddress, mobileNumber, address) VALUES ('" + studentBO.getStudentName() + "','" + studentBO.getEmailAddress() + "','" + studentBO.getMobileNumber() + "','" + studentBO.getAddress() + "')";
	   int rs=statement.executeUpdate(insert);
		if(0<rs){
			value=true;
		}  
		System.out.println("connected successfully");
		con.close();
	  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	return value;
	  
  }
  public List<StudentBO>getStudentList() throws SQLException{
	  List<StudentBO> list=new ArrayList<StudentBO>();
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/school2db", "root", "admin");
		Statement statement=(Statement)con.createStatement();

		String s="SELECT * from student";
		ResultSet r=statement.executeQuery(s);
		while(r.next()){
			StudentBO studentBO=new StudentBO();
			int id=r.getInt(1);
			String name=r.getString(2);
			String email=r.getString(3);
			String mobileNumber=r.getString(4);
			String address=r.getString(5);
			
			studentBO.setStudentId(id);
			studentBO.setStudentName(name);
			studentBO.setEmailAddress(email);
			studentBO.setMobileNumber(mobileNumber);
			studentBO.setAddress(address);
			
			System.out.println("---------Student Details----------");
			System.out.println("studentId          "+id);
			System.out.println("studentName           "+name);
			System.out.println("emailAddress         "+email);
			System.out.println("address        "+address);
			System.out.println("mobileNumber      "+mobileNumber);
			System.out.println("-----------------------------------");
			
			list.add(studentBO);
			
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return list;
	  
  }
}
