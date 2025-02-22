/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.Vehicle;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface VehicleDAO {
    
    public boolean addVehicle(Vehicle vehicle);
    public Vehicle getVehicleById(int vehicleId);
    public boolean updateVehicle(Vehicle vehicle);
    public boolean updateVehicleAsUnavaliable(String  vehicleNumber);
    public boolean updateVehicleAsAvaliable(String  vehicleNumber);
    public boolean deleteVehicle(int vehicleId);
    public List<Vehicle> getAllVehicle(String vehicleType);
    public Vehicle getVehicleid(String vehiclenumber);
            
    
}
