/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.controller.addmin;

import com.megacity.controller.SignupServlet;
import com.megacity.model.RentalPricingRule;
import com.megacity.service.RentalPricingRuleService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class FareCalculationServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FareCalculationServlet.class);

private RentalPricingRuleService rentalPricingRuleService;
   
    public FareCalculationServlet() {    
        
        rentalPricingRuleService=new RentalPricingRuleService();
    }
    

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, NumberFormatException {
    try {
        // Retrieve parameters from the request
        String daysParam = request.getParameter("days");
        String priceWithACParam = request.getParameter("vehicleWithAC");
        String priceWithoutACParam = request.getParameter("vehicleWithoutAC");
        LOGGER.info("daysParam"+daysParam);
        LOGGER.info("priceWithACParam"+priceWithACParam);
        LOGGER.info("priceWithoutACParam"+priceWithoutACParam);

        // Check if parameters are provided
        if (daysParam != null && priceWithACParam != null && priceWithoutACParam != null) {
            int days = Integer.parseInt(daysParam);
            double pricePerDayWithAC = Double.parseDouble(priceWithACParam);
            double pricePerDayWithoutAC = Double.parseDouble(priceWithoutACParam);
            double pricePerDay = pricePerDayWithAC + pricePerDayWithoutAC;

            // Get the pricing rule for the given number of days (your service logic)
            RentalPricingRule rule = rentalPricingRuleService.getAllAvailableDrivers(days);
            System.out.println(rule.toString());

            if (rule != null) {
                // Calculate base fare, discount, and tax
                double baseFare = pricePerDay * days;
                LOGGER.info("baseFare"+baseFare);
                double discount = baseFare * (rule.getDiscountPercentage().doubleValue() / 100);
                LOGGER.info("discount"+discount);
                double fareAfterDiscount = baseFare - discount;
                LOGGER.info("fareAfterDiscount"+fareAfterDiscount);
                double tax = fareAfterDiscount * (rule.getSalesTaxPercentage().doubleValue() / 100);
                LOGGER.info("tax"+tax);
                double totalFare = fareAfterDiscount + tax;
                LOGGER.info("totalFare"+totalFare);

                // Respond with JSON
                response.setContentType("application/json");
                response.getWriter().write(String.format("{\"fare\": %.2f}", totalFare));
            } else {
                // No pricing rule found
                LOGGER.info("No pricing rule found for the given rental days");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"error\": \"No pricing rule found for the given rental days\"}");
            }
        } else {
            // Missing parameters
            LOGGER.info("Missing required parameters");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Missing required parameters\"}");
        }
    } catch (NumberFormatException e) {
        LOGGER.info("Invalid number format in request parameters");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("{\"error\": \"Invalid number format in request parameters\"}");
    }
}



    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
