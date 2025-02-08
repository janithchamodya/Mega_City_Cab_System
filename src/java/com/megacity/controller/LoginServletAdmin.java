/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;

import com.megacity.model.User;
import com.megacity.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OZT00106
 */
public class LoginServletAdmin extends HttpServlet {

    private UserService userService;

    public LoginServletAdmin() {  
        userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        System.out.println("username"+username);
        System.out.println("password"+password);

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("user name and password is empty");
            response.sendRedirect("login_admin.jsp?error=1");
            return;
        }

        User user = userService.login(username, password);
        if (user != null) {
           
           response.sendRedirect("signup_admin.jsp");
     
        } else {
            System.out.println("invalide username and password");
            response.sendRedirect("login_admin.jsp?error=2");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
