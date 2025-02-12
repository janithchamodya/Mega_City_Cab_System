/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.VehicleDAO;
import com.megacity.model.Vehicle;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public class VehicleService {
    
    private VehicleDAO vehicleDAO;

    public VehicleService() {
    	vehicleDAO = new VehicleDAO();
    }
    
   public boolean addVehicleService( Vehicle vehicle){
   
   return  vehicleDAO.addVehicle(vehicle);
   }
   
   public  List<Vehicle> getAllVehicleList(String  vehicleType){
        return vehicleDAO.getAllVehicle(vehicleType);
    }
}
