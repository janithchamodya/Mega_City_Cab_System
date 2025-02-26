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
public class Bookings {
    
    private int bookingId;
    private String orderNumber;
    private int customerId;
    private int carId;
    private int driverId;
    private String customerName;
    private String model;
    private String vehicleName;
    private String vehicleNumber;
    private String owner;
    private String driverName;
    private String driverGender;
    private String amount;
    private String StartDate;
    private String EndDate;

    public Bookings() {
    }

    public Bookings(int bookingId, String orderNumber, int customerId, int carId, int driverId, String customerName, String model, String vehicleName, String vehicleNumber, String owner, String driverName, String driverGender, String amount, String StartDate, String EndDate) {
        this.bookingId = bookingId;
        this.orderNumber = orderNumber;
        this.customerId = customerId;
        this.carId = carId;
        this.driverId = driverId;
        this.customerName = customerName;
        this.model = model;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.owner = owner;
        this.driverName = driverName;
        this.driverGender = driverGender;
        this.amount = amount;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public Bookings( String OrderId,int customerId, int carId, int driverId, String customerName, String model, String vehicleName, String vehicleNumber, String owner, String driverName, String driverGender, String amount, String StartDate, String EndDate) {
        this.orderNumber=OrderId;
        this.customerId = customerId;
        this.carId = carId;
        this.driverId = driverId;
        this.customerName = customerName;
        this.model = model;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.owner = owner;
        this.driverName = driverName;
        this.driverGender = driverGender;
        this.amount = amount;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public Bookings(String orderNumber, String vehicleName, String vehicleNumber, String driverName, String amount, String StartDate, String EndDate) {
        this.orderNumber = orderNumber;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.driverName = driverName;
        this.amount = amount;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    @Override
    public String toString() {
        return "bookings{" + "bookingId=" + bookingId + ", orderNumber=" + orderNumber + ", customerId=" + customerId + ", carId=" + carId + ", driverId=" + driverId + ", customerName=" + customerName + ", model=" + model + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber + ", owner=" + owner + ", driverName=" + driverName + ", driverGender=" + driverGender + ", amount=" + amount + ", StartDate=" + StartDate + ", EndDate=" + EndDate + '}';
    }
            


    
    
            
    
}
