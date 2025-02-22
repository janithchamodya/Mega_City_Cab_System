/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao.Impl;

import com.megacity.dao.DriverDAO;
import com.megacity.model.Driver;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public class DriverDAOImpl implements DriverDAO{
    private Connection connection;
  
    public DriverDAOImpl() {
        connection = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public List<Driver> getAllAvailableDrivers() {
    List<Driver> driverList = new ArrayList<>();
    String query = "SELECT * FROM drivers WHERE availability = 'Available'";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverId(rs.getInt("driver_id"));
                driver.setDriverName(rs.getString("driver_name"));
                driver.setDriverLicenseNo(rs.getString("driver_license_no"));
                driver.setPhoneNumber(rs.getString("phone_number"));
                driver.setDriverGender(rs.getString("driver_gender"));
                driver.setAvailability(rs.getString("availability"));

                driverList.add(driver); // Add each driver object to the list
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        
    return driverList;
}
    @Override
    public boolean saveDriver(Driver driver) {
        String query = "INSERT INTO drivers (driver_name, driver_license_no, phone_number, driver_gender) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            // Set parameters based on the Driver object
            ps.setString(1, driver.getDriverName());
            ps.setString(2, driver.getDriverLicenseNo());
            ps.setString(3, driver.getPhoneNumber());
            ps.setString(4, driver.getDriverGender());
           

            int rowsAffected = ps.executeUpdate(); // Execute the update
            return rowsAffected > 0; // Return true if insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updateDriverAsUnavaliable(int driverId) {
        String query = "UPDATE drivers SET availability='Unavailable' WHERE driver_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, driverId);
           
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Return true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }
    
    @Override
    public boolean updateDriverAsAvaliable(int driverId) {
        String query = "UPDATE drivers d "
                 + "JOIN bookings b ON d.driver_id = b.driver_id "
                 + "SET d.availability = 'Available' "
                 + "WHERE b.driver_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, driverId);
           
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Return true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }
}
