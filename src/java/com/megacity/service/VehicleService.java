/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.model.Vehicle;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface VehicleService {
    public boolean addVehicleService( Vehicle vehicle);
    public  List<Vehicle> getAllVehicleList(String  vehicleType);
    public  Vehicle getvehicaleID(String  vehicleNumber);
    public boolean updateVehicleAsUnavaliable(String vehicleNumber);
    public boolean updateVehicleAsAvaliable(String vehicleNumber);
    
}
