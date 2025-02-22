/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao.Impl;

/**
 *
 * @author OZT00106
 */
import com.megacity.dao.VehicleDAO;
import com.megacity.model.Vehicle;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO{
    private Connection connection;

    
    public VehicleDAOImpl() {
        connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO Vehicle (model, vehicle_name, vehicle_number, vehicle_owner, vehicle_owner_contact,vehicle_with_ac,vehicle_without_ac, vehicle_image) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, vehicle.getModel());
            ps.setString(2, vehicle.getVehicleName());
            ps.setString(3, vehicle.getVehicleNumber());
            ps.setString(4, vehicle.getVehicleOwner());
            ps.setString(5, vehicle.getVehicleOwnerContact());
            ps.setString(6, vehicle.getVehicleWithAC());
            ps.setString(7, vehicle.getVehicleWithoutAC());
            ps.setBytes(8, vehicle.getVehicleImage());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;  

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }

    @Override
    public Vehicle getVehicleById(int vehicleId) {
        String query = "SELECT * FROM Vehicle WHERE vehicle_number = ? && ";
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
                    rs.getString("vehicle_with_ac"),
                    rs.getString("vehicle_without_ac"),
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

    @Override
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

    @Override
    public boolean updateVehicleAsUnavaliable(String  vehicleNumber) {
        String query = "UPDATE Vehicle SET availability='Unavailable' WHERE vehicle_number=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, vehicleNumber);
           
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Return true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }
    
    @Override
    public boolean updateVehicleAsAvaliable(String  vehicleNumber) {
         String query = "UPDATE Vehicle v "
                 + "JOIN bookings b ON v.vehicle_id = b.vehicle_id "
                 + "SET v.availability = 'Available' "
                 + "WHERE b.vehicle_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, vehicleNumber);
           
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Return true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }
    @Override
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
    @Override
    public List<Vehicle> getAllVehicle(String vehicleType) {
    List<Vehicle> vehicleList = new ArrayList<>();
    String query = "SELECT * FROM Vehicle Where model=? && availability='Available'";  // Assuming your table name is 'Vehicle'

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setString(1, vehicleType);
        try (ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                
                vehicle.setId(rs.getInt("vehicle_id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setVehicleName(rs.getString("vehicle_name"));
                vehicle.setVehicleNumber(rs.getString("vehicle_number"));
                vehicle.setVehicleOwner(rs.getString("vehicle_owner"));
                vehicle.setVehicleOwnerContact(rs.getString("vehicle_owner_contact"));
                vehicle.setVehicleWithAC(rs.getString("vehicle_with_ac"));
                vehicle.setVehicleWithoutAC(rs.getString("vehicle_without_ac"));
                byte[] vehicleImage = rs.getBytes("vehicle_image");
                System.out.println(vehicle.toString());
                if (vehicleImage != null) {
                    vehicle.setVehicleImage(vehicleImage);
                }

                
                vehicleList.add(vehicle);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return vehicleList;
}
    @Override
    public Vehicle getVehicleid(String vehiclenumber) {
   
    String query = "SELECT * FROM Vehicle Where vehicle_number=?";  // Assuming your table name is 'Vehicle'
    Vehicle vehicle = new Vehicle();
    try (PreparedStatement ps = connection.prepareStatement(query)) {
        
        ps.setString(1, vehiclenumber);
        try (ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                
                
                vehicle.setId(rs.getInt("vehicle_id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setVehicleName(rs.getString("vehicle_name"));
                vehicle.setVehicleNumber(rs.getString("vehicle_number"));
                vehicle.setVehicleOwner(rs.getString("vehicle_owner"));
                vehicle.setVehicleOwnerContact(rs.getString("vehicle_owner_contact"));
                vehicle.setVehicleWithAC(rs.getString("vehicle_with_ac"));
                vehicle.setVehicleWithoutAC(rs.getString("vehicle_without_ac"));
                byte[] vehicleImage = rs.getBytes("vehicle_image");
                System.out.println(vehicle.toString());
                if (vehicleImage != null) {
                    vehicle.setVehicleImage(vehicleImage);
                }

                
               
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return vehicle;
}
    
    
}

