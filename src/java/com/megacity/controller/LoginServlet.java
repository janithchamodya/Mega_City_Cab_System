/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;

import com.megacity.model.Admin;
import com.megacity.model.User;
import com.megacity.service.AdminService;
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
public class LoginServlet extends HttpServlet {

    private UserService userService;
    private AdminService adminService;

    public LoginServlet() {  // ✅ Correct constructor
        userService = new UserService();
        adminService=new AdminService();
    }

    private static final long serialVersionUID = 1L;
    
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
            response.sendRedirect("login.jsp?error=1");
            return;
        }

        User user = userService.login(username, password);
       
        //Admin and SuperAdmin
        Admin admin =adminService.Login(username, password);
        
        
        
        if (user != null  ) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            response.sendRedirect("customerdashboard.jsp");
           
            }
        else if(admin!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            
            response.sendRedirect("admindashboard.jsp");
            
            }
        else{
            response.sendRedirect("login.jsp?error=2");
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
