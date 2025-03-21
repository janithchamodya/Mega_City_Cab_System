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
public class adminViewFilterBookingsServlet extends HttpServlet {
private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(adminViewFilterBookingsServlet.class);

    private BookingService bookingService;
    private DriverService driverService;
    private VehicleService vehicleService;
    

    public adminViewFilterBookingsServlet() {    
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
        String username = request.getParameter("cId");
        
        LOGGER.info("Customer Name"+username);
        
        
        
         List<Bookings> adminViewbookingsList = bookingService.getMyBookingsFromCustID(username);
            for (Bookings bookings : adminViewbookingsList) {
                LOGGER.info("BookingId: {}", bookings.getBookingId());
                LOGGER.info("OrderNumber: {}", bookings.getOrderNumber());
                LOGGER.info("CustomerId: {}", bookings.getCustomerId());
                LOGGER.info("CarId: {}", bookings.getCarId());
                LOGGER.info("DriverId: {}", bookings.getDriverId());
                LOGGER.info("CustomerName: {}", bookings.getCustomerName());
                LOGGER.info("Model: {}", bookings.getModel());
                LOGGER.info("VehicleName: {}", bookings.getVehicleName());
                LOGGER.info("VehicleNumber: {}", bookings.getVehicleNumber());
                LOGGER.info("Owner: {}", bookings.getOwner());
                LOGGER.info("DriverName: {}", bookings.getDriverName());
                LOGGER.info("DriverGender: {}", bookings.getDriverGender());
                LOGGER.info("Amount: {}", bookings.getAmount());
                LOGGER.info("StartDate: {}", bookings.getStartDate());
                LOGGER.info("EndDate: {}", bookings.getEndDate());
                LOGGER.info("-------------------------");

         }
        request.setAttribute("adminViewbookingsList", adminViewbookingsList);
        request.getRequestDispatcher("adminViewAllBookings.jsp").forward(request, response);

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
