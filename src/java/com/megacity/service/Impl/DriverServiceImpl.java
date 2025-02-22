/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service.Impl;

import com.megacity.dao.DriverDAO;
import com.megacity.dao.Impl.DriverDAOImpl;
import com.megacity.model.Driver;
import com.megacity.model.Vehicle;
import com.megacity.service.DriverService;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class DriverServiceImpl implements  DriverService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DriverServiceImpl.class);

    private  DriverDAO driverDAO;
    
    public DriverServiceImpl(){    
        driverDAO=new DriverDAOImpl();
    }  
    @Override
     public  List<Driver> getAllAvailableDrivers(){
        LOGGER.info("getAllAvailableDrivers");
        return driverDAO.getAllAvailableDrivers();
    }
    @Override
     public boolean addDriver(Driver driver) {
        LOGGER.info("saveDriver");
        return driverDAO.saveDriver(driver);
    }
     @Override
    public boolean updateDriverAsUnavaliable(int driverId){
        LOGGER.info("updateDriverAsUnavaliable");
        return driverDAO.updateDriverAsUnavaliable(driverId);
    
    }
     
    @Override
    public boolean updateDriverAsAvaliable(int driverId){
        LOGGER.info("updateDriverAsUnavaliable");
        return driverDAO.updateDriverAsAvaliable(driverId);
    
    }

    
}
