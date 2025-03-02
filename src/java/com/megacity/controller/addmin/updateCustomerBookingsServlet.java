/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.Bookings;
import com.megacity.service.BookingService;
import com.megacity.service.DriverService;
import com.megacity.service.Impl.BookingServiceImpl;
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
public class updateCustomerBookingsServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(updateCustomerBookingsServlet.class);

    private BookingService bookingService;
    private DriverService driverService;
    private VehicleService vehicleService;
    

    public updateCustomerBookingsServlet() {    
            bookingService=new BookingServiceImpl();
            driverService=new DriverServiceImpl();
            vehicleService=new VehicleServiceImpl();
      
        }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String orderNumber = request.getParameter("orderNumber");
        String customerName = request.getParameter("customerName");
        String vehicleName = request.getParameter("vehicleName");
        String vehicleNumber = request.getParameter("vehicleNumber");
        String driverName = request.getParameter("driverName");
        String amount = request.getParameter("amount");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String vehicleId = request.getParameter("vehicleId");
        String driverId = request.getParameter("driverId");
       
        
        Bookings  bookings=new Bookings(orderNumber,customerName, amount, startDate, endDate);
       LOGGER.info("Customer Booking Details Change :{}",bookings.toString());
        if (bookingService.updateCustomerReqBooking(bookings)) {
           
            LOGGER.info("bookings details updated: {}", bookings.toString());
            response.sendRedirect("confirmReturnServlet");
        } else {
            LOGGER.error("Failed to update bookings details");
            response.sendRedirect("confirmReturn.jsp?error=1");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
