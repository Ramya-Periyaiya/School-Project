package com.School.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.School.bo.StudentBO;
import com.School.service.StudentService;

public class StudentController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();

        try {
            List<StudentBO> viewStudent = studentService.getStudentList();
            if (viewStudent != null && !viewStudent.isEmpty() && 0<viewStudent.size()) {
                request.setAttribute("studentList", viewStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String emailAddress = request.getParameter("emailAddress");
        String mobileNumber = request.getParameter("mobileNumber");
        String address = request.getParameter("address");

        StudentBO studentBO = new StudentBO();
        studentBO.setStudentName(studentName);
        studentBO.setEmailAddress(emailAddress);
        studentBO.setMobileNumber(mobileNumber);
        studentBO.setAddress(address);

        StudentService studentService = new StudentService();
        RequestDispatcher dispatcher=request.getRequestDispatcher("createStudent.jsp");
        Boolean insert = false;

        try {
            insert = studentService.saveStudent(studentBO);
            if (insert) {
                request.setAttribute("smsg", "Student Profile Created Successfully");
            } else {
                request.setAttribute("smsg", "Student Profile Creation Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately, maybe redirect to an error page
        }

        dispatcher.forward(request, response);
    }
}
