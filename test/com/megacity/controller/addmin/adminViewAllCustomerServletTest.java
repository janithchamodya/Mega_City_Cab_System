/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.User;
import com.megacity.service.UserService;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Test class for adminViewAllCustomerServlet.
 * @author OZT00106
 */
public class adminViewAllCustomerServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    UserService userService;

    @Mock
    RequestDispatcher requestDispatcher;

    @InjectMocks
    adminViewAllCustomerServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void testDoGet() throws Exception {
        
        List<User> adminViewUsersList = new ArrayList<>();
        User user1 = new User("C001", "JohnDoe", "password123", "johndoe@example.com", "123 Main St", "NIC001", "555-5555");
        User user2 = new User("C002", "JaneDoe", "password456", "janedoe@example.com", "456 Elm St", "NIC002", "555-5556");
         adminViewUsersList.add(user1);
        adminViewUsersList.add(user2);

        when(userService.getAllUserForAdminView()).thenReturn(adminViewUsersList);

        when(request.getRequestDispatcher("adminViewAllCustomer.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("adminViewUsersList", adminViewUsersList);

        verify(requestDispatcher).forward(request, response);
    }

    /**
     * Test for the doPost method, confirming it handles POST requests properly.
     */
    @Test
    public void testDoPost() throws Exception {
        
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

          when(request.getParameter("customerId")).thenReturn("1");

        servlet.doPost(request, response);

       
    }

    
}
