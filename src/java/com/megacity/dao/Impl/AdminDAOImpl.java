/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao.Impl;

import com.megacity.dao.AdminDAO;
import com.megacity.model.Admin;
import com.megacity.model.User;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class AdminDAOImpl implements AdminDAO{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AdminDAOImpl.class);

    private Connection connection;
  
    public AdminDAOImpl() {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public Admin getUserByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        String query = "SELECT * FROM admin WHERE username = ? and  password=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.toString());
                    admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    admin.setEmail(rs.getString("email"));
                    admin.setRole(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return admin;
    }
     @Override
     public Admin getUserByUserNameAndPasswordAndRole(String username, String password,String role) {
        Admin admin = null;
        String query = "SELECT * FROM admin WHERE username = ? and role=? and password=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, role);
            ps.setString(3, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.toString());
                    admin = new Admin();
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    admin.setEmail(rs.getString("email"));
                    admin.setRole(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return admin;
    }
    @Override
    public boolean addAdmin(Admin  admin) {
        String query = "INSERT INTO admin ( username, password, address, nic, phone, email, role) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getAddress());
            ps.setString(4, admin.getNic());
            ps.setString(5, admin.getPhone());
            ps.setString(6, admin.getEmail());
            ps.setString(7, admin.getRole());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("add admin exception"+e);
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean deleteAdmin(String username, String password) {
        String query = "DELETE FROM admin WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);  
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("delete admin exception: " + e);
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        String query = "SELECT * FROM admin where role='admin'";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Admin admin = new Admin();
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    admin.setAddress(rs.getString("address"));
                    admin.setNic(rs.getString("nic"));
                    admin.setPhone(rs.getString("phone"));
                    admin.setEmail(rs.getString("email"));
                    admin.setRole(rs.getString("role"));

                    adminList.add(admin); // Add each admin object to the list
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adminList;
    }
    @Override
    public boolean updateAdminDetails(Admin admin) {
        LOGGER.info("Admin :"+admin.toString());
    try {
        String query = "UPDATE admin SET password=?,address=?, nic=?, phone=?, email=?,role=? ,username=? WHERE username=?";
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setString(1, admin.getPassword());
        ps.setString(2, admin.getAddress());
        ps.setString(3, admin.getNic());
        ps.setString(4, admin.getPhone());
        ps.setString(5, admin.getEmail());  
        ps.setString(6, admin.getRole());
        ps.setString(7, admin.getUsername());
         ps.setString(8, admin.getUsername());
        int rowsUpdated = ps.executeUpdate();  
        return rowsUpdated > 0;  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;  
}
    @Override
    public List<Admin> getAllSuperAdmin() {
        List<Admin> adminList = new ArrayList<>();
        String query = "SELECT * FROM admin where role='superAdmin'";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Admin admin = new Admin();
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    admin.setAddress(rs.getString("address"));
                    admin.setNic(rs.getString("nic"));
                    admin.setPhone(rs.getString("phone"));
                    admin.setEmail(rs.getString("email"));
                    admin.setRole(rs.getString("role"));

                    adminList.add(admin); // Add each admin object to the list
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adminList;
    }
    @Override
    public boolean updateSuperAdminDetails(Admin admin) {
    try {
        String query = "UPDATE admin SET password=?, nic=?, phone=?, email=?,role=? WHERE username=?";
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setString(1, admin.getPassword());
        ps.setString(2, admin.getNic());
        ps.setString(3, admin.getPhone());
        ps.setString(4, admin.getEmail());  
        ps.setString(5, admin.getRole());
        ps.setString(6, admin.getUsername());
        int rowsUpdated = ps.executeUpdate();  
        return rowsUpdated > 0;  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;  
}
    
    
}
