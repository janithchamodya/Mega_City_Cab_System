/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.superAdmin;

import com.megacity.model.Admin;
import com.megacity.service.AdminService;
import com.megacity.service.Impl.AdminServiceImpl;
import com.megacity.service.Impl.UserServiceImpl;
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
public class deleteAdminServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(deleteAdminServlet.class);

     private AdminService adminService;
    
    public deleteAdminServlet() {  
	        
                adminService=new AdminServiceImpl();
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
        
        LOGGER.info("user name "+username+ ", password "+password);
        
        if (username == null || password == null  ) {
            response.sendRedirect("deleteAddmin.jsp?error=1");
            LOGGER.info("empty filed found");
            return;
            
        }
        Admin admin =new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        
        
        if (adminService.DeleteAdminRecord(admin)) {
            LOGGER.info(admin.toString());
            response.sendRedirect("deleteAddmin.jsp");
        } else {
            LOGGER.info("Duplicate found/Invalide values user role");
            response.sendRedirect("deleteAddmin.jsp?error=2");
        }
        
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
