/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

/**
 *
 * @author OZT00106
 */
import com.megacity.model.Vehicle;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleDAO {
    private Connection connection;

    // Constructor to initialize the DAO with the connection
    public VehicleDAO() {
        connection = DBConnection.getInstance().getConnection();
    }

    // Method to add a vehicle to the database
    public boolean addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO Vehicle (model, vehicle_name, vehicle_number, vehicle_owner, vehicle_owner_contact, vehicle_image) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, vehicle.getModel());
            ps.setString(2, vehicle.getVehicleName());
            ps.setString(3, vehicle.getVehicleNumber());
            ps.setString(4, vehicle.getVehicleOwner());
            ps.setString(5, vehicle.getVehicleOwnerContact());
            ps.setBytes(6, vehicle.getVehicleImage());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;  

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }

    // Method to get a vehicle by its ID
    public Vehicle getVehicleById(int vehicleId) {
        String query = "SELECT * FROM Vehicle WHERE vehicle_number = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, vehicleId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vehicle vehicle = new Vehicle(
                    rs.getString("model"),
                    rs.getString("vehicle_name"),
                    rs.getString("vehicle_number"),
                    rs.getString("vehicle_owner"),
                    rs.getString("vehicle_owner_contact"),
                    rs.getBytes("vehicle_image")
                );
                vehicle.setVehicleNumber(rs.getString("vehicle_number"));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if the vehicle is not found
    }

    // Method to update a vehicle's details
    public boolean updateVehicle(Vehicle vehicle) {
        String query = "UPDATE Vehicle SET model=?, vehicle_name=?, vehicle_owner=?, vehicle_owner_contact=?, vehicle_image=? WHERE vehicle_number=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, vehicle.getModel());
            ps.setString(2, vehicle.getVehicleName());
            ps.setString(3, vehicle.getVehicleOwner());
            ps.setString(4, vehicle.getVehicleOwnerContact());
            ps.setBytes(5, vehicle.getVehicleImage());
            ps.setString(6, vehicle.getVehicleNumber());
           

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Return true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }

    // Method to delete a vehicle by its ID
    public boolean deleteVehicle(int vehicleId) {
        String query = "DELETE FROM Vehicle WHERE vehicle_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, vehicleId);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;  // Return true if the deletion was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Return false if there was an issue
    }
}

