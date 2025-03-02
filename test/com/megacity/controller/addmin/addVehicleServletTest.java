package com.megacity.controller.addmin;

import com.megacity.model.Driver;
import com.megacity.model.Vehicle;
import com.megacity.service.VehicleService;
import com.megacity.service.DriverService;
import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

import static org.junit.Assert.*;

public class addVehicleServletTest {
    private addVehicleServlet servlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
    private Part mockFilePart;

    private addVehicleServlet instance;
    
    private VehicleService mockVehicleService;
    private DriverService mockDriverService;

    @Before
    public void setUp() {
        // Create mock objects
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        mockVehicleService = mock(VehicleService.class);
        mockDriverService = mock(DriverService.class);

        instance = new addVehicleServlet();
        
        instance.vehicleService = mockVehicleService;
        instance.driverService = mockDriverService;
         servlet = new addVehicleServlet();  
        mockRequest = mock(HttpServletRequest.class);  
        mockResponse = mock(HttpServletResponse.class);  
        
        // Mock the Part (file upload) object
        mockFilePart = mock(Part.class);
        
       
        try {
            when(mockFilePart.getInputStream()).thenReturn(getClass().getResourceAsStream("/testfile.jpg")); 
            when(mockFilePart.getSize()).thenReturn(1024L);  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        @Test
        public void testDoPostWithEmptyFile() throws Exception {
            // Test for doPost when no file is uploaded
            when(mockRequest.getParameter("model")).thenReturn("Model X");
            when(mockRequest.getParameter("vehicleName")).thenReturn("Tesla");
            when(mockRequest.getParameter("vehicleNumber")).thenReturn("123ABC");
            when(mockRequest.getParameter("vehicleOwner")).thenReturn("Owner");
            when(mockRequest.getParameter("vehicleOwnerContact")).thenReturn("9876543210");
            when(mockRequest.getParameter("VehicleWithAC")).thenReturn("Yes");
            when(mockRequest.getParameter("VehicleWithoutAC")).thenReturn("No");

            when(mockRequest.getPart("vehicleImage")).thenReturn(null);

            instance.doPost(mockRequest, mockResponse);

            // Verify that the error redirect happened
            verify(mockResponse).sendRedirect("addVehical.jsp?error=3");
        }
        @Test
        public void testDoPost_withNoFile() throws Exception {
            // Mock behavior for HttpServletRequest when no file is provided
            when(mockRequest.getPart("vehicleImage")).thenReturn(null);

            // Call the doPost method to test the behavior when no file is uploaded
            instance.doPost(mockRequest, mockResponse);

            // Verify interactions and assertions
            verify(mockRequest, times(1)).getPart("vehicleImage");
            verify(mockResponse, times(1)).sendRedirect("addVehical.jsp?error=3");
        }


        @Test
    public void testGetServletInfo() {
        // Test for getServletInfo method
        String result = instance.getServletInfo();
        String expected = "Handles adding a new vehicle with an image.";
        assertEquals(expected, result);
    }
}
