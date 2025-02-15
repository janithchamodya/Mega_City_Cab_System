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
public class User {
    private int Id;
    private String customerId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String nic;
    private String phone;
    private String role;
    
    // Default constructor
    public User() {}

    // Constructor with parameters
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Full constructor including all fields
    public User( String username, String password, String email, String address, String nic, String phone, String role) {
        
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.nic = nic;
        this.phone = phone;
        this.role = role;
    }

    // Getters and Setters for all fields
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", customerId=" + customerId + ", username=" + username + ", password=" + password + ", email=" + email + ", address=" + address + ", nic=" + nic + ", phone=" + phone + ", role=" + role + '}';
    }
    


}
