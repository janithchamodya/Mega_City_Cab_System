/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service.Impl;

import com.megacity.dao.UserDAO;
import com.megacity.dao.Impl.UserDAOImpl;
import com.megacity.model.User;
import com.megacity.service.UserService;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class UserServiceImpl implements UserService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;

    public UserServiceImpl() {
    	userDAO = new UserDAOImpl();
    }
    @Override
    public User login(String username, String password) {
        User user = userDAO.getUserByUsername(username,password);
        if (user != null && user.getPassword().equals(password)) { // Remove hashing for testing
            return user;
        }
        return null;
    }
    @Override
    public boolean signUpUser(User user) {
        
        String customerId = userDAO.generateCustomerId();
        LOGGER.info("customerId"+customerId);
        
        user.setCustomerId(customerId);
   
        return userDAO.addUser(user);
    }

    @Override  
    public List<User> getAllUserForAdminView( ){
        LOGGER.info("getAllUserForAdminView");
        return userDAO.getAllUserForAdminView( );
     }
    @Override
    public boolean updateUser(User user){
        LOGGER.info("updateUser from Admin");
        return userDAO.updateUser(user);
     }
     @Override
    public boolean deleteCustomer(String CustomerId){
        LOGGER.info("deleteCustomer from Admin");
        return userDAO.deleteCustomer(CustomerId);
     }
}
