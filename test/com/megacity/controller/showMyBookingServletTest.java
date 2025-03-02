/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller;



import com.megacity.model.Bookings;
import com.megacity.service.BookingService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class showMyBookingServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private BookingService bookingService;
    @Mock
    private RequestDispatcher requestDispatcher;

    @InjectMocks
    private showMyBookingServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new showMyBookingServlet();
        servlet.bookingService = bookingService;
    }

    @Test
    public void testDoGetWithValidSession() throws Exception {
        
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user_Id")).thenReturn(123);
        when(session.getAttribute("user")).thenReturn("testUser");

        
        List<Bookings> mockBookings = new ArrayList<>();
        mockBookings.add(new Bookings());
        when(bookingService.getMyBookings("123", "testUser")).thenReturn(mockBookings);

        
        when(request.getRequestDispatcher("showMyBooking.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        
        verify(bookingService).getMyBookings("123", "testUser");
        
        
        verify(request).setAttribute("mybookingsList", mockBookings);
        
        
        verify(requestDispatcher).forward(request, response);
    }


    @Test
    public void testDoGetWithEmptyBookings() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user_Id")).thenReturn(123);
        when(session.getAttribute("user")).thenReturn("testUser");

        when(bookingService.getMyBookings(anyString(), anyString())).thenReturn(new ArrayList<>());
        when(request.getRequestDispatcher("showMyBooking.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute(eq("mybookingsList"), any(List.class));
        verify(requestDispatcher).forward(request, response);
    }

    

    @Test
    public void testDoPost() throws Exception {
        servlet.doPost(request, response);
        
        verifyZeroInteractions(bookingService);
    }

    @Test
    public void testGetServletInfo() {
        assertEquals("Short description", servlet.getServletInfo());
    }
}