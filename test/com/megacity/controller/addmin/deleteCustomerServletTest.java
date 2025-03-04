/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.service.UserService;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for deleteCustomerServlet.
 */
public class deleteCustomerServletTest {

    private deleteCustomerServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private UserService userService;

    public deleteCustomerServletTest() {
    }

    @Before
    public void setUp() {
        servlet = new deleteCustomerServlet();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        userService = Mockito.mock(UserService.class);

        // Set userService in the servlet to the mock instance
        servlet.userService = userService;
    }

    @After
    public void tearDown() {
    }

   
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");

        servlet.doGet(request, response);

        verifyZeroInteractions(request);
        verifyZeroInteractions(response);
    }

    
    @Test
    public void testDoPost_Success() throws Exception {
        System.out.println("doPost Success");

        when(request.getParameter("customerId")).thenReturn("1");
        when(userService.deleteCustomer("1")).thenReturn(true); // Mock success

        servlet.doPost(request, response);

        verify(response).sendRedirect("adminViewAllCustomerServlet");
        verify(userService).deleteCustomer("1");
    }

    
    @Test
    public void testDoPost_Failure() throws Exception {
        System.out.println("doPost Failure");

        when(request.getParameter("customerId")).thenReturn("1");
        when(userService.deleteCustomer("1")).thenReturn(false); // Mock failure

        servlet.doPost(request, response);

        verify(response).sendRedirect("adminViewAllCustomer.jsp?error=1");
        verify(userService).deleteCustomer("1");
    }

    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");

        String expResult = "Short description";
        String result = servlet.getServletInfo();
        assertEquals(expResult, result);
    }

    @Test
    public void testDoPost_ServiceNull() throws Exception {
        System.out.println("doPost Service Null");

        servlet.userService = null; // Simulate null service
        when(request.getParameter("customerId")).thenReturn("1");

        try {
            servlet.doPost(request, response);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            
        }
    }

    
    @Test
    public void testDoPost_LargeCustomerId() throws Exception {
        System.out.println("doPost Large CustomerId");

        when(request.getParameter("customerId")).thenReturn("999999999");
        when(userService.deleteCustomer("999999999")).thenReturn(true);

        servlet.doPost(request, response);

        verify(userService).deleteCustomer("999999999");
        verify(response).sendRedirect("adminViewAllCustomerServlet");
    }

    @Test
    public void testDoPost_NegativeCustomerId() throws Exception {
        System.out.println("doPost Negative CustomerId");

        when(request.getParameter("customerId")).thenReturn("-1");

        servlet.doPost(request, response);

        verify(userService).deleteCustomer("-1");
        verify(response).sendRedirect("adminViewAllCustomer.jsp?error=1");
    }

    @Test
    public void testDoPost_RedirectIOException() throws Exception {
        System.out.println("doPost Redirect IOException");

        when(request.getParameter("customerId")).thenReturn("1");
        when(userService.deleteCustomer("1")).thenReturn(true);
        doThrow(new IOException()).when(response).sendRedirect("adminViewAllCustomerServlet");

        try {
            servlet.doPost(request, response);
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            
        }
    }
}
