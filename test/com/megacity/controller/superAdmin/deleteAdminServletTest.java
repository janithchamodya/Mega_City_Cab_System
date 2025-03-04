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
        // Setting up before each test
        deleteAdminServletInstance = new deleteAdminServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        
        // Mock the AdminService and inject it into the servlet
        adminService = mock(AdminService.class);
        deleteAdminServletInstance.adminService = adminService;
    }
    
    @After
    public void tearDown() {
        // Cleaning up after each test
    }

    @Test
    public void testDoGet() throws Exception {
        // Simulate the doGet behavior
        deleteAdminServletInstance.doGet(request, response);

        // Verify if correct behavior happens, e.g., redirecting to another page
        verify(response, never()).sendRedirect(anyString()); // Expect no redirect for GET requests

        // Check for other assertions if needed, depending on what doGet is supposed to do
    }

    @Test
    public void testDoPost_SuccessfulDeletion() throws Exception {
        // Simulate request parameters
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("password123");

        // Simulate successful admin deletion
        when(adminService.DeleteAdminRecord(any())).thenReturn(true);

        // Perform the POST request
        deleteAdminServletInstance.doPost(request, response);

        // Verify the successful redirect
        verify(response).sendRedirect("deleteAddmin.jsp");
        verify(adminService, times(1)).DeleteAdminRecord(any());
    }

    @Test
    public void testDoPost_FailedDeletion() throws Exception {
        // Simulate request parameters
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("password123");

        // Simulate failed admin deletion (e.g., invalid role or duplicate)
        when(adminService.DeleteAdminRecord(any())).thenReturn(false);

        // Perform the POST request
        deleteAdminServletInstance.doPost(request, response);

        // Verify the failed redirect
        verify(response).sendRedirect("deleteAddmin.jsp?error=2");
        verify(adminService, times(1)).DeleteAdminRecord(any());
    }

    @Test
    public void testDoPost_EmptyFields() throws Exception {
        // Simulate missing request parameters
        when(request.getParameter("username")).thenReturn(null);
        when(request.getParameter("password")).thenReturn(null);

        // Perform the POST request
        deleteAdminServletInstance.doPost(request, response);

        // Verify the error redirection due to empty fields
        verify(response).sendRedirect("deleteAddmin.jsp?error=1");
        verify(adminService, never()).DeleteAdminRecord(any()); // Ensure no deletion is called
    }

    @Test
    public void testGetServletInfo() {
        // Testing getServletInfo
        String result = deleteAdminServletInstance.getServletInfo();
        assertNotNull(result); // Check if the returned info is not null
    }
}
