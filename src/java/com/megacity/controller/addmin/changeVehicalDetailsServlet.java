/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.Bookings;
import com.megacity.model.Vehicle;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.Impl.VehicleServiceImpl;
import com.megacity.service.VehicleService;
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
@WebServlet(name = "changeVehicalDetailsServlet", urlPatterns = {"/changeVehicalDetailsServlet"})
public class changeVehicalDetailsServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(changeVehicalDetailsServlet.class);

    private VehicleService vehicleService;
    private DriverService driverService;
    
    
    public changeVehicalDetailsServlet() {    
        vehicleService = new VehicleServiceImpl();
        driverService=new DriverServiceImpl();
        
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List<Vehicle> vehicleList = vehicleService.getAllVehicleListWithoutType();
            for (Vehicle vehicle : vehicleList) {
                LOGGER.info("VehicleId: {}", vehicle.getId());
                LOGGER.info("Model: {}", vehicle.getModel());
                LOGGER.info("VehicleName: {}", vehicle.getVehicleName());
                LOGGER.info("VehicleNumber: {}", vehicle.getVehicleNumber());
                LOGGER.info("Owner: {}", vehicle.getVehicleOwner());
                LOGGER.info("OwnerContact: {}", vehicle.getVehicleOwnerContact());
                LOGGER.info("With AC: {}", vehicle.getVehicleWithAC());
                LOGGER.info("Without AC: {}", vehicle.getVehicleWithoutAC());
                LOGGER.info("-------------------------");
            }
            LOGGER.info("vehicleList size: {}", vehicleList.size());

            request.setAttribute("vehicleList", vehicleList);
            request.getRequestDispatcher("changeVehicalDetails.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve vehicle details from request parameters
   
    String vehicleName = request.getParameter("vehicleName");
    String vehicleNumber = request.getParameter("vehicleNumber");
    String vehicleOwner = request.getParameter("vehicleOwner");
    String vehicleOwnerContact = request.getParameter("vehicleOwnerContact");
    String vehicleWithAc = request.getParameter("vehicleWithAC");
    String vehicleWithoutAc = request.getParameter("vehicleWithoutAC");
    
    int vehicleId = Integer.parseInt(request.getParameter("vehicleId")); 
    LOGGER.info("vehicleName: " + vehicleName);
    LOGGER.info("vehicleNumber: " + vehicleNumber);
    LOGGER.info("vehicleOwner: " + vehicleOwner);
    LOGGER.info("vehicleOwnerContact: " + vehicleOwnerContact);
    LOGGER.info("vehicleWithAc: " + vehicleWithAc);
    LOGGER.info("vehicleWithoutAc: " + vehicleWithoutAc);
    LOGGER.info("vehicleId: " + vehicleId);


    // Create Vehicle object with the retrieved details
    Vehicle vehicle = new Vehicle( vehicleId,vehicleName, vehicleNumber, vehicleOwner, vehicleOwnerContact, vehicleWithAc, vehicleWithoutAc);

     
    if (vehicleService.updateVehicle(vehicle)) {
        LOGGER.info("Vehicle details updated: " + vehicle.toString());
        response.sendRedirect("changeVehicalDetailsServlet");  // Redirect to success page or refresh page
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
