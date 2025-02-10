/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.User;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OZT00106
 */
public class UserDAO {
    private Connection connection;
    

    public UserDAO() {
        connection = DBConnection.getInstance().getConnection();
    }

    public User getUserByUsername(String username,String password) {
        User user = null;
        String query = "SELECT * FROM users WHERE username = ? and password=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.toString());
                    user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    

    public boolean addUser(User user) {
        String query = "INSERT INTO users (customer_id, username, password, address, nic, phone, email, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getCustomerId()); // Index starts from 1
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getNic());
            ps.setString(6, user.getPhone());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getRole());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String generateCustomerId() {
        String query = "SELECT customer_id FROM users ORDER BY customer_id DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                System.out.println("last Customer id :"+rs.getString("customer_id"));
                String lastCustomerId = rs.getString("customer_id");
                int lastIdNum = Integer.parseInt(lastCustomerId.substring(7)); // Extracts the numeric part
                int nextIdNum = lastIdNum + 1;
                System.out.println("return customer id :"+String.format("cust_Id%03d", nextIdNum));
                return String.format("cust_Id%03d", nextIdNum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "cust_Id001"; 
    }
    
}
