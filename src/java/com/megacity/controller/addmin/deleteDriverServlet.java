/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.service.DriverService;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.Impl.VehicleServiceImpl;
import com.megacity.service.VehicleService;
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
public class deleteDriverServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(deleteDriverServlet.class);

    private VehicleService vehicleService;
    public DriverService driverService;
    
    
    public deleteDriverServlet() {    
        vehicleService = new VehicleServiceImpl();
        driverService=new DriverServiceImpl();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int driverId = Integer.parseInt(request.getParameter("driverId")); 
        
        if (driverService.deleteDriver(driverId)) {
        LOGGER.info("Delete The Vehicle , vehicleId :{}",driverId);
        response.sendRedirect("changeDriverDetailsServlet");  // Redirect to success page or refresh page
        } else {
        LOGGER.info("Error updating vehicle details");
        response.sendRedirect("changeVehicalDetails.jsp?error=1");  // Pass error code via query string
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
