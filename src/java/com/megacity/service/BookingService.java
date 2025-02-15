/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.BookingDAO;
import com.megacity.model.Bookings;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class BookingService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookingService.class);

    
     private  BookingDAO bookingDAO;
    
    public BookingService(){    
        bookingDAO=new BookingDAO();
    }
    
    
     public boolean addBookings(Bookings bookings) {
        LOGGER.info("Admin Service :"+bookings.toString());
        return bookingDAO.addBooking(bookings);
    }
}
