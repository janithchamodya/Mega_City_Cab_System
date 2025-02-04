/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.UserDAO;
import com.megacity.model.User;

/**
 *
 * @author OZT00106
 */
public class UserService {
    private UserDAO userDAO;

    public UserService() {
    	userDAO = new UserDAO();
    }

    public User login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) { // Remove hashing for testing
            return user;
        }
        return null;
    }

    public boolean signUp(User user) {
        
        String customerId = userDAO.generateCustomerId();
        System.out.println("customerId"+customerId);
        user.setCustomerId(customerId);
   
        return userDAO.addUser(user);
    }

    
    

    
}
