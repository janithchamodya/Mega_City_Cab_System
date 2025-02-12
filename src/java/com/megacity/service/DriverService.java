/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.DriverDAO;
import com.megacity.model.Driver;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public class DriverService {
  private  DriverDAO driverDAO;
    
    public DriverService(){    
        driverDAO=new DriverDAO();
    }  
    
     public  List<Driver> getAllAvailableDrivers(){
         System.out.println(driverDAO.getAllAvailableDrivers());
        return driverDAO.getAllAvailableDrivers();
    }
    
    
}
