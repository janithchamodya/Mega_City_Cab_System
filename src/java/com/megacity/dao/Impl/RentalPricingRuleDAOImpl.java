/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao.Impl;

import com.megacity.dao.RentalPricingRuleDAO;
import com.megacity.model.RentalPricingRule;
import com.megacity.service.Impl.AdminServiceImpl;
import com.megacity.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class RentalPricingRuleDAOImpl implements RentalPricingRuleDAO{
   private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RentalPricingRuleDAOImpl.class);

    private Connection connection;
  
    public RentalPricingRuleDAOImpl() {
        connection = DBConnection.getInstance().getConnection();
    }
    
    
    @Override
    public RentalPricingRule getPricingRuleForRentalDays(int rentalDays) {
    LOGGER.info("rentalDays"+rentalDays);
    if(rentalDays>1&&rentalDays<=5){rentalDays=5;}
    RentalPricingRule pricingRule = null;
    String query = "SELECT * FROM rental_pricing_rules WHERE rental_days_condition <= ? ORDER BY rental_days_condition DESC LIMIT 1";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        
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
    LOGGER.info(pricingRule.toString());
    return pricingRule;
}

}
