/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.AdminDAO;
import com.megacity.model.Admin;
import com.megacity.model.User;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public class AdminService {
    
    private  AdminDAO adminDAO;
    
    public AdminService(){    
        adminDAO=new AdminDAO();
    }
    public Admin Login(String username, String password) {
        Admin admin = adminDAO.getUserByUsernameAndPassword(username,password);
        if (admin != null && admin.getPassword().equals(password)) { // Remove hashing for testing
            return admin;
        }
        return null;
    }
    
    public Admin SuperAdminLogin(String username, String password,String role) {
        Admin admin = adminDAO.getUserByUserNameAndPasswordAndRole(username,password,role);
        if (admin != null && admin.getPassword().equals(password)) { // Remove hashing for testing
            return admin;
        }
        return null;
    }
    public boolean signUpAdmin(Admin admin) {
        System.out.println("Admin Service :"+admin.toString());
        return adminDAO.addAdmin(admin);
    }
    
    public boolean DeleteAdminRecord(Admin admin){
        System.out.println("Admin Service :"+admin.toString());
        return adminDAO.deleteAdmin(admin.getUsername(),admin.getPassword());
    }
    
    public  List<Admin> getAllAdminList(){
        return adminDAO.getAllAdmin();
    }
    
   public boolean updateAdminDetails(Admin admin){
        return adminDAO.updateAdminDetails(admin);
    
    }
    //getAllSuperAdminList
    public  List<Admin> getAllSuperAdminList(){
        return adminDAO.getAllSuperAdmin();
    }
    public boolean updateSuperAdminDetails(Admin admin){
       return adminDAO.updateAdminDetails(admin);
    
    }
    
}
