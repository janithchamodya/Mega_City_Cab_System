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
public class Vehicle {
    
    private String model;
    private String vehicleName;
    private String vehicleNumber;
    private String vehicleOwner;
    private String vehicleOwnerContact;
    private byte[]  vehicleImage;

    public Vehicle( String model, String vehicleName, String vehicleNumber, String vehicleOwner, String vehicleOwnerContact, byte[] vehicleImage) {
        
        this.model = model;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleOwner = vehicleOwner;
        this.vehicleOwnerContact = vehicleOwnerContact;
        this.vehicleImage = vehicleImage;
    }

    

    // Getters and Setters
   

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleOwnerContact() {
        return vehicleOwnerContact;
    }

    public void setVehicleOwnerContact(String vehicleOwnerContact) {
        this.vehicleOwnerContact = vehicleOwnerContact;
    }

    public byte[] getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(byte[] vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

}

