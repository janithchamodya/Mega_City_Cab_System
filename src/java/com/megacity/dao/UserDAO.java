/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.User;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface UserDAO {
    
    
    public User getUserByUsername(String username,String password);
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteCustomer(String  CustomerId);
    public String generateCustomerId();
    public List<User> getAllUserForAdminView();
}
