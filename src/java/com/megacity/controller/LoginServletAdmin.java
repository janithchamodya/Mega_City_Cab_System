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
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class LoginServletAdmin extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoginServletAdmin.class);
    private AdminService adminService;

    public LoginServletAdmin() {  
        adminService = new AdminService();
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
        String role = request.getParameter("role");
        
        
        LOGGER.info("username"+username);
        LOGGER.info("password"+password);
        

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            LOGGER.info("user name and password is empty");
            response.sendRedirect("login_admin.jsp?error=1");
            return;
        }

        Admin admin = adminService.SuperAdminLogin(username, password,role);
        if (admin != null) {
           HttpSession session = request.getSession();
           session.setAttribute("Super_addmin", admin.getUsername());
           response.sendRedirect("adminManageDashBoard.jsp");
     
        } else {
            LOGGER.info("invalide username and password");
            response.sendRedirect("login_admin.jsp?error=2");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
