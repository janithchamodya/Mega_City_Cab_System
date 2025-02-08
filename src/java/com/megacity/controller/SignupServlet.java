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

/**
 *
 * @author OZT00106
 */
public class SignupServlet extends HttpServlet {

    private UserService userService;
    
    public SignupServlet() {  // ✅ Correct constructor
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
                String email = request.getParameter("email");
                String role = request.getParameter("role");
                String nic = request.getParameter("nic");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                
                System.out.println("Username: " + username + ", Password: " + password + ", Email: " + email + 
                   ", Role: " + role + ", NIC: " + nic + ", Address: " + address + ", Phone: " + phone);


                // Check if any of the required fields are null or empty
                if (username == null || password == null || email == null || nic == null || address == null || phone == null ||
                    username.isEmpty() || password.isEmpty() || email.isEmpty() || nic.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    response.sendRedirect("signup.jsp?error=1");
                    return;
                }

                // Create a User object with the new fields
                User user = new User(username, password, email, address, nic, phone,role );

                // Call the signUp method from userService to handle the new user registration
                
                if(role=="user"){
                   if (userService.signUp(user)) {
                    System.out.println("user"+user.toString());
                    response.sendRedirect("login.jsp");
                } else {
                    System.out.println("Duplicate found/Invalide values user role");
                    response.sendRedirect("signup.jsp?error=2");
                }
                }else{
                    if (userService.signUp(user)) {
                        System.out.println("user"+user.toString());
                        response.sendRedirect("login_admin.jsp");
                    } else {
                        System.out.println("Duplicate found/Invalide values user role");
                        response.sendRedirect("signup_admin.jsp?error=2");
                    }
                
                }
                
                
                
               
                
                
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
