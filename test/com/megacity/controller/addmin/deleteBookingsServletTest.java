package com.megacity.controller.addmin;

import com.megacity.service.BookingService;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class deleteBookingsServletTest {
    
    private deleteBookingsServlet servlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
    private BookingService mockBookingService;
    
    @Before
    public void setUp() {
        servlet = new deleteBookingsServlet();
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        mockBookingService = mock(BookingService.class);
        
        servlet.bookingService = mockBookingService;
    }
    
    @After
    public void tearDown() {
        // Reset mocks after each test
        reset(mockRequest, mockResponse, mockBookingService);
    }

    /**
     * Test of doPost method for successful booking deletion
     */
    @Test
    public void testDoPost_Success() throws Exception {
        System.out.println("testDoPost_Success");
        
        when(mockRequest.getParameter("orderNumber")).thenReturn("ORD_001");
        when(mockBookingService.deleteBooking("ORD_001")).thenReturn(true);

        servlet.doPost(mockRequest, mockResponse);
        
        verify(mockResponse).sendRedirect("adminViewAllBookingsServlet");
    }

    /**
     * Test of doPost method for failed booking deletion
     */
    @Test
    public void testDoPost_Failure() throws Exception {
        System.out.println("testDoPost_Failure");
        
        when(mockRequest.getParameter("orderNumber")).thenReturn("ORD_001");
        when(mockBookingService.deleteBooking("ORD_001")).thenReturn(false);

        servlet.doPost(mockRequest, mockResponse);
        
        verify(mockResponse).sendRedirect("adminViewAllBookingsServlet.jsp?error=1");
    }


    @Test
    public void testGetServletInfo() {
        System.out.println("testGetServletInfo");
        
        deleteBookingsServlet instance = new deleteBookingsServlet();
        String expResult = "Short description";
        String result = instance.getServletInfo();
        
        assertEquals(expResult, result);
    }
}
