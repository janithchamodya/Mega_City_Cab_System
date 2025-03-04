package com.megacity.controller.addmin;

import com.megacity.service.BookingService;
import com.megacity.model.Bookings;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class adminViewAllBookingsServletTest {

    @Mock
    private BookingService bookingService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @InjectMocks
    private adminViewAllBookingsServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class adminViewAllBookingsServlet.
     */
    @Test
    public void testDoGet() throws Exception {
        // Set up mock data
        List<Bookings> bookingsList = new ArrayList<>();
        Bookings booking = new Bookings();
        booking.setOrderNumber("123");
        booking.setVehicleName("Sedan");
        booking.setVehicleNumber("AB1234");
        booking.setDriverName("John Doe");
        booking.setAmount("5000");
        booking.setStartDate("2025-02-01");
        booking.setEndDate("2025-02-10");
        bookingsList.add(booking);

        when(bookingService.getAllBookingsForAdminView()).thenReturn(bookingsList);
        when(request.getRequestDispatcher("adminViewAllBookings.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("adminViewbookingsList", bookingsList);
        verify(requestDispatcher).forward(request, response);
    }

    
}
