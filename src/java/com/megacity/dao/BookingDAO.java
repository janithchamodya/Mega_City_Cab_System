/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.Bookings;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author OZT00106
 */
public class BookingDAO {
 private Connection connection;

    public BookingDAO() {
        connection = DBConnection.getInstance().getConnection();
    }

    public boolean addBooking(Bookings booking) {
        String query = "INSERT INTO bookings (order_number, customer_id, vehicle_id, driver_id, customer_name, " +
                       "model, vehicle_name, vehicle_number, owner, driver_name, driver_gender, amount, " +
                       "start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, booking.getOrderNumber());
            ps.setInt(2, booking.getCustomerId());
            ps.setInt(3, booking.getCarId());
            ps.setInt(4, booking.getDriverId());
            ps.setString(5, booking.getCustomerName());
            ps.setString(6, booking.getModel());
            ps.setString(7, booking.getVehicleName());
            ps.setString(8, booking.getVehicleNumber());
            ps.setString(9, booking.getOwner());
            ps.setString(10, booking.getDriverName());
            ps.setString(11, booking.getDriverGender());
            ps.setString(12, booking.getAmount());
            ps.setString(13, booking.getStartDate());
            ps.setString(14, booking.getEndDate());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error while adding booking: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }   
}
