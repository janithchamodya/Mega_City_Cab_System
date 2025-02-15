/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service;

import com.megacity.dao.RentalPricingRuleDAO;
import com.megacity.model.RentalPricingRule;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class RentalPricingRuleService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RentalPricingRuleService.class);

   private  RentalPricingRuleDAO rentalPricingRuleDAO;
    
    public RentalPricingRuleService(){    
        rentalPricingRuleDAO=new RentalPricingRuleDAO();
    } 
    
    
    public  RentalPricingRule getAllAvailableDrivers(int days){
         System.out.println(rentalPricingRuleDAO.getPricingRuleForRentalDays(days));
        return rentalPricingRuleDAO.getPricingRuleForRentalDays(days);
    }
}
