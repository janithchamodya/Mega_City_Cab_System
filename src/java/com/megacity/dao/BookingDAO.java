/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.Bookings;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface BookingDAO {
    
    public boolean addBooking(Bookings booking);
    public List<Bookings> getAvailableBooking();
    public List<Bookings> getMyBookings(String customerId ,String customerName);
    public boolean updateBookingAsUnavailable(String orderNumber);
    public String generateOrderNumber();
    
            
    
}
