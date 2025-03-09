/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;

import com.megacity.model.Admin;
import com.megacity.model.User;
import com.megacity.service.AdminService;
import com.megacity.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private UserService userService;
    @Mock
    private AdminService adminService;
    @Mock
    private Logger logger;

    private LoginServlet loginServlet;
    private final ArgumentCaptor<String> redirectCaptor = ArgumentCaptor.forClass(String.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loginServlet = new LoginServlet();
        loginServlet.userService = userService;
        loginServlet.adminService = adminService;
        loginServlet.setLogger(LoggerFactory.getLogger(LoginServlet.class));
    }

    @Test
    public void testValidUserLogin() throws Exception {
        
        when(request.getParameter("username")).thenReturn("janith");
        when(request.getParameter("password")).thenReturn("1234");
        when(request.getSession()).thenReturn(session);

        
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("janith");
        mockUser.setCustomerId("cust_Id001");
        when(userService.login("janith", "1234")).thenReturn(mockUser);

        
        loginServlet.doPost(request, response);

        
        verify(response).sendRedirect("customerdashboard.jsp");
        
        
        verify(session).setAttribute("user", "janith");
        verify(session).setAttribute("user_Id", 1);
    }

    @Test
    public void testValidAdminLogin() throws Exception {
        when(request.getParameter("username")).thenReturn("chamodya123");
        when(request.getParameter("password")).thenReturn("1330");
        when(request.getSession()).thenReturn(session);

        Admin mockAdmin = new Admin();
        mockAdmin.setId(100);
        mockAdmin.setUsername("chamodya123");
        when(adminService.Login("chamodya123", "1330")).thenReturn(mockAdmin);

        loginServlet.doPost(request, response);

        verify(response).sendRedirect("admindashboard.jsp");
        verify(session).setAttribute("admin", "chamodya123");
        verify(session).setAttribute("admin_Id", 100);
    }

    @Test
    public void testEmptyCredentials() throws Exception {
        when(request.getParameter("username")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        
        loginServlet.doPost(request, response);
        
        verify(response).sendRedirect("login.jsp?error=1");
    }

    @Test
    public void testInvalidCredentials() throws Exception {
        when(request.getParameter("username")).thenReturn("invalid");
        when(request.getParameter("password")).thenReturn("wrong");
        when(userService.login(anyString(), anyString())).thenReturn(null);
        when(adminService.Login(anyString(), anyString())).thenReturn(null);

        loginServlet.doPost(request, response);
        
        verify(response).sendRedirect("login.jsp?error=2");
    }
    @Test
    public void testNullUsernameCorrectPassword() throws Exception {
        when(request.getParameter("username")).thenReturn(null);
        when(request.getParameter("password")).thenReturn("1234");
        when(request.getSession()).thenReturn(session);

        loginServlet.doPost(request, response);

        verify(response).sendRedirect("login.jsp?error=1");
        verify(userService, never()).login(anyString(), anyString());
        verify(adminService, never()).Login(anyString(), anyString());
    }
    @Test
    public void testCorrectUsernameNullPassword() throws Exception {
        when(request.getParameter("username")).thenReturn("janith");
        when(request.getParameter("password")).thenReturn(null);
        when(request.getSession()).thenReturn(session);

        loginServlet.doPost(request, response);

        verify(response).sendRedirect("login.jsp?error=1");
        verify(userService, never()).login(anyString(), anyString());
        verify(adminService, never()).Login(anyString(), anyString());
    }
    @Test
    public void testGetServletInfo() {
        assertEquals("Short description", loginServlet.getServletInfo());
    }
}