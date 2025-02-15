/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.model;

/**
 *
 * @author OZT00106
 */
public class Driver {
    private int driverId;
    private String driverName;
    private String driverLicenseNo;
    private String phoneNumber;
    private String driverGender;
    private String availability;

    public Driver() {
    }

    public Driver( String driverName, String driverLicenseNo, String phoneNumber, String driverGender) {
        
        this.driverName = driverName;
        this.driverLicenseNo = driverLicenseNo;
        this.phoneNumber = phoneNumber;
        this.driverGender = driverGender;
        
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Driver{" + "driverId=" + driverId + ", driverName=" + driverName + ", driverLicenseNo=" + driverLicenseNo + ", phoneNumber=" + phoneNumber + ", driverGender=" + driverGender + ", availability=" + availability + '}';
    }

   
    
    
    
}
