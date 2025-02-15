/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.VehicleDAO;
import com.megacity.model.Vehicle;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class VehicleService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

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
   public  Vehicle getvehicaleID(String  vehicleNumber){
        return vehicleDAO.getVehicleid(vehicleNumber);
    }
   public boolean updateVehicleAsUnavaliable(String vehicleNumber){
   return vehicleDAO.updateVehicleAsUnavaliable(vehicleNumber);}
}
