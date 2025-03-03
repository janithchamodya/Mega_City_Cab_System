/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.Driver;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.Impl.VehicleServiceImpl;
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
public class changeDriverDetailsServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(changeDriverDetailsServlet.class);

    private VehicleService vehicleService;
    public DriverService driverService;
    
    
    public changeDriverDetailsServlet() {    
        vehicleService = new VehicleServiceImpl();
        driverService=new DriverServiceImpl();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Driver> driversList = driverService.getAllAvailableDrivers();

        for (Driver driver : driversList) {
            LOGGER.info("DriverId: {}", driver.getDriverId());
            LOGGER.info("DriverName: {}", driver.getDriverName());
            LOGGER.info("License Number: {}", driver.getDriverLicenseNo());
            LOGGER.info("Phone Number: {}", driver.getPhoneNumber());
            LOGGER.info("Gender: {}", driver.getDriverGender());
            LOGGER.info("Availability: {}", driver.getAvailability());
            LOGGER.info("-------------------------");
        }

        LOGGER.info("driversList size: {}", driversList.size());

        // In changeDriverDetailsServlet.java
        request.setAttribute("driversList", driversList); // Correct attribute name
        request.getRequestDispatcher("changeDriverDetails.jsp").forward(request, response);
    }

        
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String driverName = request.getParameter("driverName");
        String licenseNumber = request.getParameter("licenseNumber");
        String phoneNumber = request.getParameter("phoneNumber");
        String driverGender = request.getParameter("driverGender");
        int driverId = Integer.parseInt(request.getParameter("driverId"));

        LOGGER.info("Driver Name: {}", driverName);
        LOGGER.info("License Number: {}", licenseNumber);
        LOGGER.info("Phone Number: {}", phoneNumber);
        LOGGER.info("Gender: {}", driverGender);
        LOGGER.info("Driver ID: {}", driverId);


        Driver driver=new Driver(driverId,driverName, licenseNumber, phoneNumber, driverGender);

        if (driverService.updateDriver(driver)) {
            LOGGER.info("Driver details updated: {}", driver.toString());
            response.sendRedirect("changeDriverDetailsServlet");
        } else {
            LOGGER.error("Failed to update driver details");
            response.sendRedirect("changeDriverDetails.jsp?error=1");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
