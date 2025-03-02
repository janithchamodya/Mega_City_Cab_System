/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.controller.LoginServlet;
import com.megacity.model.Driver;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.Impl.VehicleServiceImpl;
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
public class addDriverServlet extends HttpServlet {
    private  org.slf4j.Logger LOGGER ;
    public DriverService driverService;

    public addDriverServlet() {    

            driverService=new DriverServiceImpl();
            this.LOGGER = LoggerFactory.getLogger(LoginServlet.class);
        }
    
    void setLogger(org.slf4j.Logger logger) {
    this.LOGGER = logger;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

   
   @Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String driverName = request.getParameter("driverName");
    String driverLicenseNo = request.getParameter("driverLicenseNo");
    String phoneNumber = request.getParameter("phoneNumber");
    String driverGender = request.getParameter("driverGender");

    
    LOGGER.info("Driver Name: " + driverName);
    LOGGER.info("Driver License No: " + driverLicenseNo);
    LOGGER.info("Phone Number: " + phoneNumber);
    LOGGER.info("Driver Gender: " + driverGender);

    
    Driver driver = new Driver(driverName, driverLicenseNo, phoneNumber, driverGender);
    if (driverName == null || driverLicenseNo == null || phoneNumber == null || driverGender == null) {
        LOGGER.error("Duplicate found/Invalid values or missing parameters");
        response.sendRedirect("addDriver.jsp?error=1"); // Redirect to an error page
        return;
    }
    
    boolean success = driverService.addDriver(driver);

    
    if (success) {
        response.sendRedirect("addDriver.jsp?success=1");
    } else {
        LOGGER.info("Duplicate found/Invalide values user role");
        response.sendRedirect("addDriver.jsp?error=1");
    }


       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
