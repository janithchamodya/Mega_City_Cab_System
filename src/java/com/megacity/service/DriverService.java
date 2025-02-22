/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.model.Driver;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface DriverService {
    
    public  List<Driver> getAllAvailableDrivers();
    public boolean addDriver(Driver driver);
    public boolean updateDriverAsUnavaliable(int driverId);
    public boolean updateDriverAsAvaliable(int driverId);
    public boolean updateDriver(Driver driver);
    public boolean deleteDriver(int driverId);
    
}
