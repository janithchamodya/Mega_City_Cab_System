package com.megacity.controller.superAdmin;

import com.megacity.model.Admin;
import com.megacity.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class changeAddminDataServletTest {

    @InjectMocks
    private changeAddminDataServlet servlet;

    @Mock
    private AdminService adminService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
      
        List<Admin> adminList = new ArrayList<>();
        adminList.add(new Admin("admin1", "pass1", "admin1@icbt.com", "Address1", "123456789V", "0712345678", "Admin"));

        when(adminService.getAllAdminList()).thenReturn(adminList);

        when(request.getRequestDispatcher("changeAddminData.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("adminList", adminList);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_successfulUpdate() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("username")).thenReturn("admin1");
        when(request.getParameter("password")).thenReturn("Pass123");
        when(request.getParameter("email")).thenReturn("admin1@combank.com");
        when(request.getParameter("address")).thenReturn("New york");
        when(request.getParameter("nic")).thenReturn("123456789V");
        when(request.getParameter("phone")).thenReturn("0712345678");
        when(request.getParameter("role")).thenReturn("Admin");

        when(adminService.updateAdminDetails(any(Admin.class))).thenReturn(true);

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeAddminDataServlet");
    }

    @Test
    public void testDoPost_failedUpdate() throws ServletException, IOException {
        
        when(request.getParameter("username")).thenReturn("admin1");
        when(request.getParameter("password")).thenReturn("Pass1");
        when(request.getParameter("email")).thenReturn("admin1@example123.com");
        when(request.getParameter("address")).thenReturn("New Address");
        when(request.getParameter("nic")).thenReturn("123456789V");
        when(request.getParameter("phone")).thenReturn("0712345678");
        when(request.getParameter("role")).thenReturn("Admin");

        when(adminService.updateAdminDetails(any(Admin.class))).thenReturn(false);

        servlet.doPost(request, response);

        verify(response).sendRedirect("changeAddminData.jsp?error=1");
    }
}
