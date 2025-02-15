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
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class SignupServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SignupServlet.class);

    private UserService userService;
    private AdminService adminService;
    
    public SignupServlet() {  // ✅ Correct constructor
	        userService = new UserService();
                adminService=new AdminService();
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
                
                LOGGER.info(" Username: " + username + ", Password: " + password + ", Email: " + email + 
                   ", Role: " + role + ", NIC: " + nic + ", Address: " + address + ", Phone: " + phone);


                // Check if any of the required fields are null or empty
                if (username == null || password == null || email == null || nic == null || address == null || phone == null ||
                    username.isEmpty() || password.isEmpty() || email.isEmpty() || nic.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    response.sendRedirect("signup.jsp?error=1");
                    LOGGER.info("empty filed found");
                    return;
                }

             
              
                // Call the signUp method from userService to handle the new user registration
               
                if("user".equals(role)){
                    LOGGER.info("user sign up");
                    User user = new User(username, password, email, address, nic, phone,role );
                   if (userService.signUpUser(user)) {
                    LOGGER.info(user.toString());
                    response.sendRedirect("login.jsp");
                } else {
                    LOGGER.info("Duplicate found/Invalide values user role");
                    response.sendRedirect("signup.jsp?error=2");
                }
                }
                else{
                    LOGGER.info("admin sign up");
                    Admin admin =new Admin(username, password, email, address, nic, phone, role);
                    System.out.println("admin 123"+ admin.toString());
                    if (!adminService.signUpAdmin(admin)) {
                        LOGGER.info("Duplicate found/Invalide values admin role");
                        response.sendRedirect("addAddmin.jsp?error=2");
                    } else {
                        LOGGER.info(admin.toString());
                        response.sendRedirect("addAddmin.jsp");
                    }
                  
                }
                
              
               
               
                
                
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
