/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service.Impl;

import com.megacity.controller.superAdmin.deleteAdminServlet;
import com.megacity.dao.AdminDAO;
import com.megacity.dao.Impl.AdminDAOImpl;
import com.megacity.model.Admin;
import com.megacity.model.User;
import com.megacity.service.AdminService;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */

public class AdminServiceImpl implements AdminService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    
    private  AdminDAO adminDAO;
    
    public AdminServiceImpl(){    
        adminDAO=new AdminDAOImpl();
    }
    @Override
    public Admin Login(String username, String password) {
        Admin admin = adminDAO.getUserByUsernameAndPassword(username,password);
        if (admin != null && admin.getPassword().equals(password)) { // Remove hashing for testing
            return admin;
        }
        return null;
    }
    @Override
    public Admin SuperAdminLogin(String username, String password,String role) {
        Admin admin = adminDAO.getUserByUserNameAndPasswordAndRole(username,password,role);
        if (admin != null && admin.getPassword().equals(password)) { // Remove hashing for testing
            return admin;
        }
        return null;
    }
    @Override
    public boolean signUpAdmin(Admin admin) {
        LOGGER.info("Admin Service :"+admin.toString());
        return adminDAO.addAdmin(admin);
    }
    @Override
    public boolean DeleteAdminRecord(Admin admin){
        LOGGER.info("Admin Service :"+admin.toString());
        return adminDAO.deleteAdmin(admin.getUsername(),admin.getPassword());
    }
    @Override
    public  List<Admin> getAllAdminList(){
        LOGGER.info("getAllAdminList");
        return adminDAO.getAllAdmin();
    }
    @Override
   public boolean updateAdminDetails(Admin admin){
        LOGGER.info("updateAdminDetails");
        return adminDAO.updateAdminDetails(admin);
    
    }
    @Override
    public  List<Admin> getAllSuperAdminList(){
        LOGGER.info("getAllSuperAdminList");
        return adminDAO.getAllSuperAdmin();
    }
    @Override
    public boolean updateSuperAdminDetails(Admin admin){
        LOGGER.info("updateSuperAdminDetails");
       return adminDAO.updateAdminDetails(admin);
    
    }
    
}
