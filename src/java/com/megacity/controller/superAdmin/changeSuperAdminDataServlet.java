/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.superAdmin;

import com.megacity.model.Admin;
import com.megacity.service.AdminService;
import com.megacity.service.Impl.AdminServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
@WebServlet(name = "changeSuperAdminDataServlet", urlPatterns = {"/changeSuperAdminDataServlet"})
public class changeSuperAdminDataServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(changeSuperAdminDataServlet.class);

     private AdminService adminService;
    
    public changeSuperAdminDataServlet() {  
	        
            adminService=new AdminServiceImpl();
	    }
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Admin> adminList = adminService.getAllSuperAdminList();
            for (Admin admin : adminList) {
                LOGGER.info("Username: {}", admin.getUsername());
                LOGGER.info("NIC: {}", admin.getNic());
                LOGGER.info("Phone: {}", admin.getPhone());
                LOGGER.info("Email: {}", admin.getEmail());
                LOGGER.info("Role: {}", admin.getRole());
                LOGGER.info("-------------------------");

         }
        request.setAttribute("adminList", adminList);
        request.getRequestDispatcher("changeSuperAdminData.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String nic = request.getParameter("nic");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        Admin admin=new Admin(username, phone, email, role, nic, phone, role);
       
        if (adminService.updateSuperAdminDetails(admin)) {
        LOGGER.info("Admin details updated: " + admin.toString());
        response.sendRedirect("changeSuperAdminData.jsp?success=1");  // Redirect to success page or refresh page
        } else {
            LOGGER.info("Error updating admin details");
            response.sendRedirect("changeSuperAdminData.jsp?error=1");  // Pass error code via query string
        }
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
