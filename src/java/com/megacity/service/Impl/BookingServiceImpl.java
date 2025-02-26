/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service.Impl;

import com.megacity.dao.BookingDAO;
import com.megacity.dao.Impl.BookingDAOImpl;
import com.megacity.model.Bookings;
import com.megacity.service.BookingService;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class BookingServiceImpl implements BookingService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

    
     private  BookingDAO bookingDAO;
    
    public BookingServiceImpl(){    
        bookingDAO=new BookingDAOImpl();
    }
    
    @Override
     public boolean addBookings(Bookings bookings) {
        LOGGER.info("addBookings Service :"+bookings.toString());
        
      
        return bookingDAO.addBooking(bookings);
    }
    @Override
    public List<Bookings> getAvailableBooking(){
        LOGGER.info("getAvailableBooking");
        return bookingDAO.getAvailableBooking();
     }
    @Override  
    public List<Bookings> getMyBookings(String customerId ,String customerName){
        LOGGER.info("getMyBookings");
        return bookingDAO.getMyBookings(customerId ,customerName);
     }
     @Override  
    public List<Bookings> getMyBookingsFromCustID(String customerId ){
        LOGGER.info("getMyBookings");
        return bookingDAO.getMyBookingsFromCustID(customerId );
     }
    @Override  
    public List<Bookings> getAllBookingsForAdminView(){
        LOGGER.info("getAllBookingsForAdminView");
        return bookingDAO.getAllBookingsForAdminView();
     }
    
    @Override
    public boolean updateASUnavailableBooking(String orderNumber){
        LOGGER.info("updateASUnavailableBooking");
        return bookingDAO.updateBookingAsUnavailable(orderNumber);
     }
    @Override
    public boolean updateBooking(Bookings bookings){
        LOGGER.info("updateBooking from Admin");
        return bookingDAO.updateBooking(bookings);
     }
    @Override
    public boolean deleteBooking(String orderNumber){
        LOGGER.info("deleteBooking from Admin");
        return bookingDAO.deleteBooking(orderNumber);
     }
    @Override
    public String generateOrderNumber(){
        LOGGER.info("generateOrderNumber");
        return  bookingDAO.generateOrderNumber();
    }
}
