/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.Driver;
import com.megacity.service.DriverService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 *
 * @author OZT00106
 */
public class changeDriverDetailsServletTest {

    private changeDriverDetailsServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private DriverService driverService;
    private RequestDispatcher requestDispatcher;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        servlet = new changeDriverDetailsServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        driverService = mock(DriverService.class);
        requestDispatcher = mock(RequestDispatcher.class);

        servlet.driverService = driverService; // Set the mock service
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class changeDriverDetailsServlet.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");

        List<Driver> driversList = new ArrayList<>();
        driversList.add(new Driver(1, "John Doe", "L12345", "1234567890", "Male"));
        when(driverService.getAllAvailableDrivers()).thenReturn(driversList);

        when(request.getRequestDispatcher("changeDriverDetails.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("driversList", driversList); // Verify driver list is set in request attribute
        verify(requestDispatcher).forward(request, response); // Verify forward to JSP page
    }

    

    @Test
    public void testDoPost_Failure() throws Exception {
        System.out.println("doPost Failure");

        when(request.getParameter("driverName")).thenReturn("John Doe");
        when(request.getParameter("licenseNumber")).thenReturn("L12345");
        when(request.getParameter("phoneNumber")).thenReturn("1234567890");
        when(request.getParameter("driverGender")).thenReturn("Male");
        when(request.getParameter("driverId")).thenReturn("1");

        Driver driver = new Driver(1, "John Doe", "L12345", "1234567890", "Male");

        when(driverService.updateDriver(driver)).thenReturn(false);

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeDriverDetails.jsp?error=1"); // Verify redirect to error page on failure
    }

    /**
     * Test of getServletInfo method, of class changeDriverDetailsServlet.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        changeDriverDetailsServlet instance = new changeDriverDetailsServlet();
        String result = instance.getServletInfo();
        assertEquals("Short description", result); // Expected result
    }
}
