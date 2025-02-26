/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.model.User;
import java.util.List;
/**
 *
 * @author OZT00106
 */
public interface UserService {
    
    public User login(String username, String password);
    public boolean signUpUser(User user);//
     public List<User> getAllUserForAdminView();
    
}
