/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.service.DriverService;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for deleteDriverServlet.
 */
public class deleteDriverServletTest {

    private deleteDriverServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private DriverService driverService;

    public deleteDriverServletTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        servlet = new deleteDriverServlet();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        driverService = Mockito.mock(DriverService.class);

        
        servlet.driverService = driverService;
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

        when(request.getParameter("driverId")).thenReturn("1");
        when(driverService.deleteDriver(1)).thenReturn(true); // Mock success

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeDriverDetailsServlet");
        verify(driverService).deleteDriver(1);
    }

    
    @Test
    public void testDoPost_Failure() throws Exception {
        System.out.println("doPost Failure");

        when(request.getParameter("driverId")).thenReturn("1");
        when(driverService.deleteDriver(1)).thenReturn(false); // Mock failure

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeVehicalDetails.jsp?error=1");
        verify(driverService).deleteDriver(1);
    }

    @Test(expected = NumberFormatException.class)
    public void testDoPost_InvalidDriverId() throws Exception {
        System.out.println("doPost Invalid DriverId");

        when(request.getParameter("driverId")).thenReturn("invalid");

        servlet.doPost(request, response);

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

        servlet.driverService = null; // Simulate null service
        when(request.getParameter("driverId")).thenReturn("1");

        try {
            servlet.doPost(request, response);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            
        }
    }

    
    @Test
    public void testDoPost_LargeDriverId() throws Exception {
        System.out.println("doPost Large DriverId");

        when(request.getParameter("driverId")).thenReturn("999999999");
        when(driverService.deleteDriver(999999999)).thenReturn(true);

        servlet.doPost(request, response);

        verify(driverService).deleteDriver(999999999);
        verify(response).sendRedirect("changeDriverDetailsServlet");
    }

    
    @Test
    public void testDoPost_NegativeDriverId() throws Exception {
        System.out.println("doPost Negative DriverId");

        when(request.getParameter("driverId")).thenReturn("-1");

        servlet.doPost(request, response);

        verify(driverService).deleteDriver(-1);
        verify(response).sendRedirect("changeVehicalDetails.jsp?error=1");
    }

    @Test
    public void testDoPost_RedirectIOException() throws Exception {
        System.out.println("doPost Redirect IOException");

        when(request.getParameter("driverId")).thenReturn("1");
        when(driverService.deleteDriver(1)).thenReturn(true);
        doThrow(new IOException()).when(response).sendRedirect("changeDriverDetailsServlet");

       
        try {
            servlet.doPost(request, response);
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            
        }
    }
}
