/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.model.Bookings;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface BookingService {
    
    public boolean addBookings(Bookings bookings);
    public List<Bookings> getAvailableBooking();
    public List<Bookings> getMyBookings(String customerId ,String customerName);
    public List<Bookings> getMyBookingsFromCustID(String customerId );
    public List<Bookings> getAllBookingsForAdminView();
    public boolean updateASUnavailableBooking(String orderNumber);
    public boolean updateBooking(Bookings bookings);
    public boolean deleteBooking(String orderNumber);
    public String  generateOrderNumber();
    
}
