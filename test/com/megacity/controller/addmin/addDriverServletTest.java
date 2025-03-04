/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.model.Driver;
import com.megacity.service.DriverService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;

public class addDriverServletTest {

    private addDriverServlet addDriverServlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
    private DriverService mockDriverService;

    @Before
    public void setUp() {
        addDriverServlet = new addDriverServlet();
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        mockDriverService = mock(DriverService.class);
        
        addDriverServlet.driverService = mockDriverService; // Injecting the mocked DriverService
    }

    @Test
    public void testDoPost_Success() throws Exception {
        
        when(mockRequest.getParameter("driverName")).thenReturn("John Doe");
        when(mockRequest.getParameter("driverLicenseNo")).thenReturn("DL12345");
        when(mockRequest.getParameter("phoneNumber")).thenReturn("1234567890");
        when(mockRequest.getParameter("driverGender")).thenReturn("Male");

        
        when(mockDriverService.addDriver(any(Driver.class))).thenReturn(true);

        addDriverServlet.doPost(mockRequest, mockResponse);

        // Assert
        verify(mockDriverService, times(1)).addDriver(any(Driver.class));
        verify(mockResponse).sendRedirect("addDriver.jsp?success=1");
    }

    @Test
    public void testDoPost_MissingParameters() throws Exception {
       
        when(mockRequest.getParameter("driverName")).thenReturn(null);
        when(mockRequest.getParameter("driverLicenseNo")).thenReturn("DL12345");
        when(mockRequest.getParameter("phoneNumber")).thenReturn("1234567890");
        when(mockRequest.getParameter("driverGender")).thenReturn("Male");

        addDriverServlet.doPost(mockRequest, mockResponse);

        // Assert
        verify(mockDriverService, times(0)).addDriver(any(Driver.class)); // Service should not be called
        verify(mockResponse).sendRedirect("addDriver.jsp?error=1"); // Error redirection
    }

    @Test
    public void testDoPost_AddDriverFailure() throws Exception {
        // Arrange - Valid parameters but simulating a failure in driver addition
        when(mockRequest.getParameter("driverName")).thenReturn("John Doe");
        when(mockRequest.getParameter("driverLicenseNo")).thenReturn("DL12345");
        when(mockRequest.getParameter("phoneNumber")).thenReturn("1234567890");
        when(mockRequest.getParameter("driverGender")).thenReturn("Male");

        // Simulate failure to add driver
        when(mockDriverService.addDriver(any(Driver.class))).thenReturn(false);

        // Act
        addDriverServlet.doPost(mockRequest, mockResponse);

        // Assert
        verify(mockDriverService, times(1)).addDriver(any(Driver.class));
        verify(mockResponse).sendRedirect("addDriver.jsp?error=1");
    }
}
