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
public class Admin {
    private int id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String nic;
    private String phone;
    private String role;
    
    
    public Admin() {}

    // Constructor with parameters
    public Admin(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Full constructor including all fields
    public Admin(String username, String password, String email, String address, String nic, String phone, String role) {
        
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.nic = nic;
        this.phone = phone;
        this.role = role;
        System.out.println("admin");
    }

    // Getters and Setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", address=" + address + ", nic=" + nic + ", phone=" + phone + ", role=" + role + '}';
    }
    
    

}
