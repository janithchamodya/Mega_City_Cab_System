/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.DriverDAO;
import com.megacity.model.Driver;
import com.megacity.model.Vehicle;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class DriverService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DriverService.class);

    private  DriverDAO driverDAO;
    
    public DriverService(){    
        driverDAO=new DriverDAO();
    }  
    
     public  List<Driver> getAllAvailableDrivers(){
         System.out.println(driverDAO.getAllAvailableDrivers());
        return driverDAO.getAllAvailableDrivers();
    }
    
     public boolean addDriver(Driver driver) {
        return driverDAO.saveDriver(driver);
    }
     
    public boolean updateDriverAsUnavaliable(int driverId){
    return driverDAO.updateDriverAsUnavaliable(driverId);
    
    }
     

    
}
