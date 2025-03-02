/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.megacity.model.User;
import com.megacity.model.Admin;
import com.megacity.service.AdminService;
import com.megacity.service.UserService;
import java.io.IOException;

public class SignupServletTest {

    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private UserService userService;
    @Mock private AdminService adminService;
    
    private SignupServlet signupServlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        signupServlet = new SignupServlet();
        signupServlet.userService = userService;
        signupServlet.adminService = adminService;
    }

    
    @Test
    public void testSuccessfulUserSignup() throws Exception {
        mockRequestParams("user123", "pass123", "user@test.com", "user", "123456789", "123 Street", "0771234567");
        when(userService.signUpUser(any(User.class))).thenReturn(true);
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("login.jsp");
        verify(userService).signUpUser(any(User.class));
    }

   
    @Test
    public void testSuccessfulAdminSignup() throws Exception {
        mockRequestParams("admin123", "adminPass", "admin@test.com", "admin", "987654321", "456 Road", "0777654321");
        when(adminService.signUpAdmin(any(Admin.class))).thenReturn(true);
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("addAddmin.jsp");
        verify(adminService).signUpAdmin(any(Admin.class));
    }

   
    @Test
    public void testMissingUsername() throws Exception {
        mockRequestParams(null, "pass123", "user@test.com", "user", "123456789", "123 Street", "0771234567");
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("signup.jsp?error=1");
        verifyZeroInteractions(userService, adminService);
    }

    
    @Test
    public void testMissingPassword() throws Exception {
        mockRequestParams("user123", null, "user@test.com", "user", "123456789", "123 Street", "0771234567");
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("signup.jsp?error=1");
        verifyZeroInteractions(userService, adminService);
    }

    
    @Test
    public void testMissingEmail() throws Exception {
        mockRequestParams("user123", "pass123", null, "user", "123456789", "123 Street", "0771234567");
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("signup.jsp?error=1");
        verifyZeroInteractions(userService, adminService);
    }

    
    @Test
    public void testDuplicateUser() throws Exception {
        mockRequestParams("user123", "pass123", "user@test.com", "user", "123456789", "123 Street", "0771234567");
        when(userService.signUpUser(any(User.class))).thenReturn(false);
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("signup.jsp?error=2");
    }

    @Test
    public void testMissingNIC() throws Exception {
        mockRequestParams("user123", "pass123", "user@test.com", "user", null, "123 Street", "0771234567");
        
        signupServlet.doPost(request, response);
        
        verify(response).sendRedirect("signup.jsp?error=1");
        verifyZeroInteractions(userService, adminService);
    }

    private void mockRequestParams(String username, String password, String email, 
                                  String role, String nic, String address, String phone) {
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("role")).thenReturn(role);
        when(request.getParameter("nic")).thenReturn(nic);
        when(request.getParameter("address")).thenReturn(address);
        when(request.getParameter("phone")).thenReturn(phone);
    }
}