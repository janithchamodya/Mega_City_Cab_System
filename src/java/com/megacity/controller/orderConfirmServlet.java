/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;

import com.megacity.model.Bookings;
import com.megacity.service.BookingService;
import com.megacity.service.Impl.BookingServiceImpl;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.DriverServiceImpl;
import com.megacity.service.Impl.RentalPricingRuleServiceImpl;
import com.megacity.service.VehicleService;
import com.megacity.service.Impl.VehicleServiceImpl;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class orderConfirmServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(orderConfirmServlet.class);

    public BookingService bookingService;
    public DriverService driverService;
    public VehicleService vehicleService;

    public orderConfirmServlet() {    

            bookingService=new BookingServiceImpl();
            driverService=new DriverServiceImpl();
            vehicleService=new VehicleServiceImpl();
            
        }
      long unixTimestamp = System.currentTimeMillis() / 1000;
      long shortTimestamp = unixTimestamp % 1000;   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int driverId=0;
        String driverName=null;              
        String driverGender=null;         
        String driverLicenseNo=null;      
        String driverPhone=null;
        int userId=Integer.parseInt(request.getParameter("userId"));
        String userName=request.getParameter("userName");
        
        String model = request.getParameter("vehicleModel");
        String vehicleName = request.getParameter("vehicleName");
        String vehicleNumber = request.getParameter("vehicleNumber");
        String vehicleOwner = request.getParameter("vehicleOwner");
        String vehicleOwnerContact = request.getParameter("vehicleOwnerContact");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        LOGGER.info("startDate"+startDate);
        LOGGER.info("endDate"+endDate);
        
        String drivervalues = request.getParameter("driverSelect");
        LOGGER.info("Selected driver: " + drivervalues);
  
        String regex = "ID: (\\d+), Name: ([^,]+), Gender: ([^,]+), License No: ([^,]+), Phone: ([^;]+);?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(drivervalues);

        // Ensure the matcher finds a match before accessing groups
        if (matcher.find()) {
            driverId = Integer.parseInt(matcher.group(1));  
            driverName = matcher.group(2);              
            driverGender = matcher.group(3);             
            driverLicenseNo = matcher.group(4);          
            driverPhone = matcher.group(5);             

            LOGGER.info("Driver ID: " + driverId);
            LOGGER.info("Driver Name: " + driverName);
            LOGGER.info("Driver Gender: " + driverGender);
            LOGGER.info("Driver License No: " + driverLicenseNo);
            LOGGER.info("Driver Phone: " + driverPhone);
            
        } else {
            LOGGER.info("No match found.");
        }
       
        String amount = request.getParameter("fareInput").substring(24);
        double vehicleWithAC = Double.parseDouble(request.getParameter("vehicleWithAC"));
        double vehicleWithoutAC = Double.parseDouble(request.getParameter("vehicleWithoutAC"));
        
        
        String customerName =userName; 
         
         int vehicleid=(vehicleService.getvehicaleID(vehicleNumber)).getId();
         String OrderId =bookingService.generateOrderNumber();
         LOGGER.info("OrderId"+OrderId);
        
         
         Bookings bookings=new  Bookings( OrderId,userId,vehicleid,driverId,customerName,model, vehicleName, vehicleNumber, vehicleOwner, driverName,driverGender, amount, startDate, endDate);
        System.out.println(bookings.toString());
         if (bookingService.addBookings(bookings)) {
            
            String driverUpdateStatus = (driverService.updateDriverAsUnavaliable(driverId)) ? "updated" : "failed";
            String vehicleUpdateStatus = (vehicleService.updateVehicleAsUnavaliable(vehicleNumber)) ? "updated" : "failed";

            // Optionally, log or print the statuses
            LOGGER.info("Driver Update Status: " + driverUpdateStatus);
            LOGGER.info("Vehicle Update Status: " + vehicleUpdateStatus);

            
            request.setAttribute("orderNumber", OrderId); // Assuming ID is generated
            request.setAttribute("vehicleModel", model);
            request.setAttribute("vehicleName", vehicleName);
            request.setAttribute("vehicleNumber", vehicleNumber);
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
            request.setAttribute("totalFare", amount);
            request.setAttribute("driverName", driverName);
            request.setAttribute("bookingStatus", "Confirmed");

            // 6. Forward to confirmation page
            RequestDispatcher dispatcher = request.getRequestDispatcher("showConfirmPDF.jsp");
            dispatcher.forward(request, response);
            
        } else {
            
            response.sendRedirect("showAvaliableVehicle.jsp?error=2");
        }
         
         
         
         
         
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
