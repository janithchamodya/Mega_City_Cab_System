/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.service.VehicleService;
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
 * Unit tests for deleteVehicleServlet.
 */
public class deleteVehicleServletTest {

    private deleteVehicleServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private VehicleService vehicleService;

    public deleteVehicleServletTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        servlet = new deleteVehicleServlet();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        vehicleService = Mockito.mock(VehicleService.class);

        servlet.vehicleService = vehicleService; 
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class deleteVehicleServlet.
     * Since doGet doesn't contain logic, this can be minimal.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");

        servlet.doGet(request, response);

        
        verifyZeroInteractions(request);
        verifyZeroInteractions(response);
    }

    /**
     * Test of doPost method, of class deleteVehicleServlet.
     */
    @Test
    public void testDoPost_Success() throws Exception {
        System.out.println("doPost Success");

        when(request.getParameter("vehicleId")).thenReturn("123");
        when(vehicleService.deleteVehicle(123)).thenReturn(true); 

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeVehicalDetailsServlet");
        verify(vehicleService).deleteVehicle(123);  
    }

    @Test
    public void testDoPost_Failure() throws Exception {
        System.out.println("doPost Failure");

        when(request.getParameter("vehicleId")).thenReturn("123");
        when(vehicleService.deleteVehicle(123)).thenReturn(false); 

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeVehicalDetails.jsp?error=1");
        verify(vehicleService).deleteVehicle(123);  
    }

    /**
     * Test of getServletInfo method, of class deleteVehicleServlet.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");

        String expResult = "Short description";
        String result = servlet.getServletInfo();
        assertEquals(expResult, result);
    }
}
