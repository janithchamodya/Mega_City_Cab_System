/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.RentalPricingRule;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OZT00106
 */
public class RentalPricingRuleDAO {
  
    private Connection connection;
  
    public RentalPricingRuleDAO() {
        connection = DBConnection.getInstance().getConnection();
    }
    
    
    
    public RentalPricingRule getPricingRuleForRentalDays(int rentalDays) {
    RentalPricingRule pricingRule = null;
    String query = "SELECT * FROM rental_pricing_rules WHERE rental_days_condition <= ? ORDER BY rental_days_condition DESC LIMIT 1";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        // Setting rental_days_condition dynamically
        ps.setInt(1, rentalDays);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                pricingRule = new RentalPricingRule();
                pricingRule.setDiscountPercentage(rs.getBigDecimal("discount_percentage"));
                pricingRule.setSalesTaxPercentage(rs.getBigDecimal("sales_tax_percentage"));
               
                pricingRule.setDescription(rs.getString("description"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pricingRule;
}

}
