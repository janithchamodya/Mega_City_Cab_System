/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.Admin;
import java.util.List;

/**
 *
 * @author OZT00106
 */
public interface AdminDAO {
    
        public Admin getUserByUsernameAndPassword(String username, String password);
        public Admin getUserByUserNameAndPasswordAndRole(String username, String password,String role);
        public boolean addAdmin(Admin  admin);
        public boolean deleteAdmin(String username, String password);
        public List<Admin> getAllAdmin();
        public boolean updateAdminDetails(Admin admin);
        public List<Admin> getAllSuperAdmin();
        public boolean updateSuperAdminDetails(Admin admin);
}
