/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.service.AdminService;
import com.megacity.service.Impl.AdminServiceImpl;
import com.megacity.service.Impl.UserServiceImpl;
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
public class deleteCustomerServlet extends HttpServlet {
private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(deleteCustomerServlet.class);

    
    public UserService userService;
    private AdminService adminService;
    
    public deleteCustomerServlet() {  
	        userService = new UserServiceImpl();
                adminService=new AdminServiceImpl();
	    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String customerId = request.getParameter("customerId"); 
        LOGGER.info("customerId"+customerId);
        
        if (userService.deleteCustomer(customerId)) {
        LOGGER.info("Delete The Customer , Customer :{}",customerId);
        response.sendRedirect("adminViewAllCustomerServlet");  
        } else {
        LOGGER.info("Error updating Customer details");
        response.sendRedirect("adminViewAllCustomer.jsp?error=1"); 
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
