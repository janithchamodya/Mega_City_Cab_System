/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service.Impl;

import com.megacity.dao.Impl.VehicleDAOImpl;
import com.megacity.model.Vehicle;
import com.megacity.service.VehicleService;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class VehicleServiceImpl implements  VehicleService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(VehicleServiceImpl.class);

    private VehicleDAOImpl vehicleDAO;

    public VehicleServiceImpl() {
    	vehicleDAO = new VehicleDAOImpl();
    }
   @Override
   public boolean addVehicleService( Vehicle vehicle){
        LOGGER.info("addVehicle");
        return  vehicleDAO.addVehicle(vehicle);
   }
   @Override
   public  List<Vehicle> getAllVehicleList(String  vehicleType){
       LOGGER.info("getAllVehicleList");
       return vehicleDAO.getAllVehicle(vehicleType);
    }
   @Override
   public  Vehicle getvehicaleID(String  vehicleNumber){
       LOGGER.info("getVehicleid");
       return vehicleDAO.getVehicleid(vehicleNumber);
    }
   @Override
   public boolean updateVehicleAsUnavaliable(String vehicleNumber){
       LOGGER.info("updateVehicleAsUnavaliable");
       return vehicleDAO.updateVehicleAsUnavaliable(vehicleNumber);
   }
   
   @Override
   public boolean updateVehicleAsAvaliable(String vehicleNumber){
       LOGGER.info("updateVehicleAsUnavaliable");
       return vehicleDAO.updateVehicleAsAvaliable(vehicleNumber);
   }
}
