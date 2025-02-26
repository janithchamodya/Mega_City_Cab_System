/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.Bookings;
import com.megacity.model.User;
import com.megacity.service.AdminService;
import com.megacity.service.BookingService;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.AdminServiceImpl;
import com.megacity.service.Impl.BookingServiceImpl;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.Impl.UserServiceImpl;
import com.megacity.service.Impl.VehicleServiceImpl;
import com.megacity.service.UserService;
import com.megacity.service.VehicleService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class adminViewAllCustomerServlet extends HttpServlet {
private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(adminViewAllCustomerServlet.class);

    
    private UserService userService;
    private AdminService adminService;
    
    public adminViewAllCustomerServlet() {  
	        userService = new UserServiceImpl();
                adminService=new AdminServiceImpl();
	    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<User> adminViewUsersList = userService.getAllUserForAdminView();  // Ensure the method exists

        // Iterate through users and log the information
        for (User user : adminViewUsersList) {
            LOGGER.info("UserId: {}", user.getId());
            LOGGER.info("CustomerId: {}", user.getCustomerId());
            LOGGER.info("Username: {}", user.getUsername());
            LOGGER.info("Password: {}", user.getPassword());
            LOGGER.info("Address: {}", user.getAddress());
            LOGGER.info("NIC: {}", user.getNic());
            LOGGER.info("Phone: {}", user.getPhone());
            LOGGER.info("Email: {}", user.getEmail());
            LOGGER.info("Role: {}", user.getRole());
            LOGGER.info("-------------------------");
        }

        // Set the user list as a request attribute and forward to the JSP
        request.setAttribute("adminViewUsersList", adminViewUsersList);
        request.getRequestDispatcher("adminViewAllCustomer.jsp").forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
