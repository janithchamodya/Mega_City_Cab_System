/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OZT00106
 */
public class showBookingServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String startPlace = request.getParameter("startPlace");
        String destinationPlace = request.getParameter("destinationPlace");

        // You can now save this booking information to a database
        // For example:
        // BookingService.addBooking(new Booking(startPlace, destinationPlace));

        // For simplicity, let's just print the values to the console
        System.out.println("Start Place: " + startPlace);
        System.out.println("Destination Place: " + destinationPlace);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
