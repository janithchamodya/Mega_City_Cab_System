package com.megacity.controller.addmin;

import com.megacity.service.BookingService;
import com.megacity.service.DriverService;
import com.megacity.service.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class deleteCustomerBookingsServletTest {

    @Mock
    private BookingService bookingService;

    @Mock
    private DriverService driverService;

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private deleteCustomerBookingsServlet instance;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() {
        
    }

    

    @Test
    public void testDoPost_FailureInBookingDeletion() throws Exception {
        
        String orderNumber = "12345";
        String vehicleId = "V123";
        String driverId = "D123";
        
        when(request.getParameter("orderNumber")).thenReturn(orderNumber);
        when(request.getParameter("vehicleId")).thenReturn(vehicleId);
        when(request.getParameter("driverId")).thenReturn(driverId);
        
        when(bookingService.deleteBooking(orderNumber)).thenReturn(false);

        instance.doPost(request, response);

        verify(response).sendRedirect("confirmReturn.jsp?error=1");
    }

    

    
    @Test
    public void testGetServletInfo() {
       
        deleteCustomerBookingsServlet instance = new deleteCustomerBookingsServlet();
        
        String result = instance.getServletInfo();
        
        assertNotNull(result); 
    }
}
