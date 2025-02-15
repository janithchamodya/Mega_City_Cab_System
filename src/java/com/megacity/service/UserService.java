/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.UserDAO;
import com.megacity.model.User;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class UserService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserDAO userDAO;

    public UserService() {
    	userDAO = new UserDAO();
    }

    public User login(String username, String password) {
        User user = userDAO.getUserByUsername(username,password);
        if (user != null && user.getPassword().equals(password)) { // Remove hashing for testing
            return user;
        }
        return null;
    }

    public boolean signUpUser(User user) {
        
        String customerId = userDAO.generateCustomerId();
        LOGGER.info("customerId"+customerId);
        
        user.setCustomerId(customerId);
   
        return userDAO.addUser(user);
    }

    
    

    
}
