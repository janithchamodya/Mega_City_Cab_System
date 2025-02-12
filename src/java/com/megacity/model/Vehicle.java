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
    private String vehicleWithAC;
    private String vehicleWithoutAC;
    private byte[] vehicleImage;   
    private String base64Image;    

   
    public Vehicle() {}

    
    public Vehicle(String model, String vehicleName, String vehicleNumber, String vehicleOwner, 
                   String vehicleOwnerContact, String vehicleWithAC, String vehicleWithoutAC, byte[] vehicleImage) {
        this.model = model;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleOwner = vehicleOwner;
        this.vehicleOwnerContact = vehicleOwnerContact;
        this.vehicleWithAC = vehicleWithAC;
        this.vehicleWithoutAC = vehicleWithoutAC;
        this.vehicleImage = vehicleImage;
    }

    
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

    public String getVehicleWithAC() {
        return vehicleWithAC;
    }

    public void setVehicleWithAC(String vehicleWithAC) {
        this.vehicleWithAC = vehicleWithAC;
    }

    public String getVehicleWithoutAC() {
        return vehicleWithoutAC;
    }

    public void setVehicleWithoutAC(String vehicleWithoutAC) {
        this.vehicleWithoutAC = vehicleWithoutAC;
    }

    // Getter and Setter for vehicleImage (byte array)
    public byte[] getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(byte[] vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    // Getter and Setter for base64Image (Base64 encoded string)
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "Vehicle [model=" + model + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber + ", vehicleOwner=" + vehicleOwner
                + ", vehicleOwnerContact=" + vehicleOwnerContact + ", vehicleWithAC=" + vehicleWithAC + ", vehicleWithoutAC=" + vehicleWithoutAC + "]";
    }
}


