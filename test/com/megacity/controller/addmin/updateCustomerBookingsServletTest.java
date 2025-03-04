/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.controller.addmin.updateCustomerBookingsServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.megacity.model.Bookings;
import com.megacity.service.BookingService;

/**
 *
 * @author OZT00106
 */
public class updateCustomerBookingsServletTest {

    private updateCustomerBookingsServlet servlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
    private BookingService mockBookingService;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servlet = new updateCustomerBookingsServlet();
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        mockBookingService = mock(BookingService.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class updateCustomerBookingsServlet.
     * Since doGet method is empty, we expect nothing to happen.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        servlet.doGet(mockRequest, mockResponse);
       
        verifyZeroInteractions(mockRequest, mockResponse);
    }

    /**
     * Test of doPost method, of class updateCustomerBookingsServlet.
     * This test will check for the flow of updating customer booking data.
     */
    

    @Test
    public void testDoPostFailure() throws Exception {
        System.out.println("doPost - failure case");

        when(mockRequest.getParameter("orderNumber")).thenReturn("ORD123");
        when(mockRequest.getParameter("customerName")).thenReturn("John Doe");
        when(mockRequest.getParameter("amount")).thenReturn("100");
        when(mockRequest.getParameter("startDate")).thenReturn("2025-01-01");
        when(mockRequest.getParameter("endDate")).thenReturn("2025-01-05");
        
        when(mockBookingService.updateCustomerReqBooking(any(Bookings.class))).thenReturn(false);

        servlet.doPost(mockRequest, mockResponse);

        verify(mockResponse).sendRedirect("confirmReturn.jsp?error=1");
    }

    /**
     * Test of getServletInfo method, of class updateCustomerBookingsServlet.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        updateCustomerBookingsServlet instance = new updateCustomerBookingsServlet();
        String expected = "Short description";
        String result = instance.getServletInfo();
        assertEquals(expected, result);
    }
}
