package com.School.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.School.bo.LoginBO;
import com.School.service.LoginService;

public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("passwords");

        LoginBO login = new LoginBO();
        login.setUserName(userName);
        login.setPasswords(password);

        LoginService loginService = new LoginService();
        try {
            boolean isValidLogin = loginService.checkLogin(login);

            if (isValidLogin) {
                request.setAttribute("smsg", "Login Success");
                RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("smsg", "Username or Password is Incorrect");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
          
        }
    }
}
