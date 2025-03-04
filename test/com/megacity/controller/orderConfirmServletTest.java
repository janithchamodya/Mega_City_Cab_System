package com.megacity.controller;

import com.megacity.controller.orderConfirmServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Unit test for orderConfirmServlet.
 */
public class orderConfirmServletTest {
    
    private orderConfirmServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public orderConfirmServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servlet = new orderConfirmServlet();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class orderConfirmServlet.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        servlet.doGet(request, response);

        // Verify that the response was not interacted with
        Mockito.verifyZeroInteractions(response);
    }

    

    /**
     * Test of getServletInfo method, of class orderConfirmServlet.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        String expResult = "Short description";
        String result = servlet.getServletInfo();
        assertEquals(expResult, result);
    }
}
