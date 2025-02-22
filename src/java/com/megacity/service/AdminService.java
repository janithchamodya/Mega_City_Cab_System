/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.model.Admin;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface AdminService {
    
    public Admin Login(String username, String password);
    public Admin SuperAdminLogin(String username, String password,String role);
    public boolean signUpAdmin(Admin admin);
    public boolean DeleteAdminRecord(Admin admin);
    public  List<Admin> getAllAdminList();
    public boolean updateAdminDetails(Admin admin);
    public  List<Admin> getAllSuperAdminList();
    public boolean updateSuperAdminDetails(Admin admin);
}
