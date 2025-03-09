package com.megacity.controller.superAdmin;

import com.megacity.service.AdminService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class deleteAdminServletTest {
    
    private deleteAdminServlet deleteAdminServletInstance;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private AdminService adminService;

    @BeforeClass
    public static void setUpClass() {
        // Runs once before all tests
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Runs once after all tests
    }
    
    @Before
    public void setUp() {
      
        deleteAdminServletInstance = new deleteAdminServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
      
        adminService = mock(AdminService.class);
        deleteAdminServletInstance.adminService = adminService;
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void testDoGet() throws Exception {
       
        deleteAdminServletInstance.doGet(request, response);

        verify(response, never()).sendRedirect(anyString()); 

        
    }

    @Test
    public void testDoPost_SuccessfulDeletion() throws Exception {
        
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("password123");

        when(adminService.DeleteAdminRecord(any())).thenReturn(true);

        deleteAdminServletInstance.doPost(request, response);

        verify(response).sendRedirect("deleteAddmin.jsp");
        verify(adminService, times(1)).DeleteAdminRecord(any());
    }

    @Test
    public void testDoPost_FailedDeletion() throws Exception {
        // Simulate request parameters
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("password123");

        when(adminService.DeleteAdminRecord(any())).thenReturn(false);

        deleteAdminServletInstance.doPost(request, response);

        verify(response).sendRedirect("deleteAddmin.jsp?error=2");
        verify(adminService, times(1)).DeleteAdminRecord(any());
    }

    @Test
    public void testDoPost_EmptyFields() throws Exception {
        
        when(request.getParameter("username")).thenReturn(null);
        when(request.getParameter("password")).thenReturn(null);

        deleteAdminServletInstance.doPost(request, response);

        verify(response).sendRedirect("deleteAddmin.jsp?error=1");
        verify(adminService, never()).DeleteAdminRecord(any()); 
    }

    @Test
    public void testGetServletInfo() {
        
        String result = deleteAdminServletInstance.getServletInfo();
        assertNotNull(result);
    }
}
