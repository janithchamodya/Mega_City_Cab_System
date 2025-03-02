/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;

import com.megacity.model.Admin;
import com.megacity.model.User;
import com.megacity.service.AdminService;
import com.megacity.service.Impl.AdminServiceImpl;
import com.megacity.service.UserService;
import com.megacity.service.Impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
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
public class LoginServlet extends HttpServlet {
 private  org.slf4j.Logger LOGGER ;

    public UserService userService;
    public AdminService adminService;

    public LoginServlet() {  
        userService = new UserServiceImpl();
        adminService=new AdminServiceImpl();
        this.LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    }
    void setLogger(org.slf4j.Logger logger) {
    this.LOGGER = logger;
    }
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        LOGGER.info("username"+username);
        LOGGER.info("password"+password);

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            LOGGER.info("user name and password is empty");
            response.sendRedirect("login.jsp?error=1");
            return;
        }

        User user = userService.login(username, password);
       
        Admin admin =adminService.Login(username, password);
        
        
        
        if (user != null  ) {
            HttpSession session = request.getSession();
            LOGGER.info(user.toString());
            LOGGER.info("username :"+user.getUsername()+" customer id :"+user.getCustomerId());
            session.setAttribute("user", user.getUsername());
            session.setAttribute("user_Id", user.getId());
           
                    
            response.sendRedirect("customerdashboard.jsp");
           
            }
        else if(admin!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin.getUsername());
            session.setAttribute("admin_Id", admin.getId());
            
            
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
